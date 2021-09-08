// On my honor:
//
// - I have not discussed the Java language code in my program with
// anyone other than my instructor or the teaching assistants
// assigned to this course.
//
// - I have not used Java language code obtained from another student,
// or any other unauthorized source, including the Internet, either
// modified or unmodified.
//
// - If any Java language code or documentation used in my program
// was obtained from another source, such as a text book or course
// notes, that has been clearly noted with a proper citation in
// the comments of my program.
//
// - I have not designed this program in such a way as to defeat or
// interfere with the normal operation of the supplied grading code.
//
// Vishesh Fogla
// visheshfogla

//  Project 1 for CS 3114 Spring 2021
//
//  Programmer:    Vishesh Fogla
//  OS:            Windows 2010 
//  System:        i5 7th gen, 1 TB Memory
//  Last modified: February 3, 2021

//  Purpose
//  The program reads a gis data file and parses through every record. 
//  It is able to write the offest and feature name of a record to an output file through indexing. 
//  In addition to that the program is able to read a commands file and output the value of a given 
//  offset that the command requires.
//

import java.io.File;
import java.util.Formatter;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.io.IOException;

/**
 * 
 * @author Vishesh
 * 
 *         The class establishes a main method that serves as the driver of the
 *         program to read in input from the two input files and then parse
 *         through the files for writing the required information to the output
 *         file
 */
public class GISParser {

	/**
	 * @param outputStream The stream to the given log file (in order to write to
	 *                     the file).
	 * @param commandCount To keep count of the number of commands executed.
	 * @param request      A parser for the GIS command file.
	 * @param idx          A parser for the GIS data file.
	 */
	static commandParser request;
	static indexParser idx;
	static FileWriter outputStream;

	static String check;
	static int commandCount;

	/**
	 *
	 * @param args main requires two parameters which are input files that contain
	 *             data and commands respectively. The data and commands are then
	 *             parsed and required information is written to the output file.
	 */
	public static void main(String[] args) {

		// Checks if the User has given correct arguments for the program to run
		// accurately.
		if (args.length < 3) {
			System.err.println("Invalid number of arguments - " + "GIS file and Output file is required");
			System.exit(1);
		} else if (args.length > 4) {
			System.err.println("Invalid number of arguments -" + "GIS file, Command file and Output File is required");
			System.exit(1);
		}

		check = args[0];

		// If testing for index and writing offsets to the output file.
		if (check.contains("index")) {

			// Storing the input file into local file variables in order to operate on them.
			File gisFile = new File(args[1]);
			idx = new indexParser(gisFile);

			// The third parameter on the command line is the output file in this case.
			File outputFile = new File(args[2]);
			try {
				outputStream = new FileWriter(outputFile);
			} catch (IOException e) {
				System.err.println("When opening file I/O error occured.");
				System.exit(1);
			}

			writeLine("File contains the following records:\n\n");
			try {
				RandomAccessFile gisStream = new RandomAccessFile(gisFile, "r");
				Formatter obj = new Formatter();
				long offset;

				while ((gisStream.readLine()) != null) {
					if (gisStream.getFilePointer() >= gisStream.length())
						break;
					offset = gisStream.getFilePointer();
					obj.format("\t%12d\t%s\n", offset, idx.getFeatureName(offset));
				}
				writeLine(obj.toString());
				writeLine("\n");
				gisStream.close();
				obj.close();
			} catch (IOException e) {
				System.err.println("When reading file I/O error occured.");
				System.exit(1);
			}
		} else if (check.contains("search")) {

			// Storing the input file into local file variables in order to operate on them.
			File gisFile = new File(args[1]);
			File commandFile = new File(args[2]);
			idx = new indexParser(gisFile);
			request = new commandParser(commandFile);

			// The fourth parameter on the command line is the output file in this case.
			File outputFile = new File(args[3]);
			try {
				outputStream = new FileWriter(outputFile);
			} catch (IOException e) {
				System.err.println("When writing to file I/O error occured.");
				System.exit(1);
			}

			commandCount = 0;
			request.parseCmd();

			CmdForm cmd = request.getCurrentCommand();
			long offset;

			// keeps running thorugh the loop until all the commands are parsed and updates
			// the command count.
			while (cmd != CmdForm.QUIT) {
				offset = request.getCurrentOffset();
				writeLine(execute(cmd, offset));

				request.parseCmd();
				cmd = request.getCurrentCommand();
			}

			writeLine(execute(cmd, 0));

			idx.close();
			request.close();
			try {
				outputStream.close();
			} catch (IOException e) {
			}
		}

	}

	/**
	 * 
	 * The method executes a given command as the parser parses through the command
	 * file. The method matches the offset to the type of the command and
	 * accordingly returns the appropriate offset that the command wishes to know.
	 * 
	 * @param cmd    The command that needs to be executed.
	 * @param offset that is to be printed if it matches the command form.
	 * @return a string after executing the given command and then print the value
	 *         of the requested offset.
	 */
	static String execute(CmdForm cmd, long offset) {
		Formatter obj2 = new Formatter();
		String printLine = null;
		commandCount++;

		obj2.format("%4d:\t%s\n", commandCount, request.toString());

		if (cmd == CmdForm.SHOW_NAME) {
			obj2.format("\t%s\n", idx.getFeatureName(offset));
		} else if (cmd == CmdForm.SHOW_LATITUDE) {
			obj2.format("\t%s\n", idx.getLatitude(offset));
		} else if (cmd == CmdForm.SHOW_LONGITUDE) {
			obj2.format("\t%s\n", idx.getLongitude(offset));
		} else if (cmd == CmdForm.SHOW_ELEVATION) {
			obj2.format("\t%s\n", idx.getElevation(offset));
		} else if (cmd == CmdForm.QUIT) {
			obj2.format("\tExiting\n");
		}

		printLine = obj2.toString();
		obj2.close();
		return printLine;

	}

	/**
	 * 
	 * The method writes a line to the output file.
	 * 
	 * @param outputLine Output line printed to the log file.
	 */
	static void writeLine(String outputLine) {
		try {
			outputStream.write(outputLine);
			outputStream.flush();
		} catch (IOException e) {
			System.err.println("In log file I/O error occured.");
			System.exit(1);
		}
	}

}

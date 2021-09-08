//  Project 1 for CS 3114 Spring 2021
//
//  Programmer:    Vishesh Fogla
//  OS:            Windows 2010 
//  System:        i5 7th gen, 1 TB Memory
//  Last modified: February 3, 2021


import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * 
 * A class that parses through the GIS command file and returns the required
 * output for the given command.
 * 
 * @author Vishesh
 *
 */
public class commandParser {

	/**
	 * @param commandStream The stream for the file that has the GIS commands.
	 * @param currCmd       a variable that keeps track of the current command that
	 *                      is being parsed.
	 * @param currOffset    Offset that is being parsed.
	 * @param offsetParam   To check if there exists a record in the given line.
	 */
	public RandomAccessFile commandStream;
	public String currCommand;
	public long currOffset;
	public boolean checkOffset;

	/**
	 * Defining a constructor that takes the gis commands file and sets up a stream.
	 * If the file does not exist, then it throws an exception.
	 * 
	 * @param cmdFile The file that stores the commands to be parsed.
	 * 
	 */
	public commandParser(File cmdFile) {

		try {
			commandStream = new RandomAccessFile(cmdFile, "r");
		} catch (FileNotFoundException e) {
			System.err.println("File" + cmdFile.getName() + "could not be found");
			System.exit(1);
		}
	}

	/**
	 * Method that closes the stream defined in teh constuctor.
	 */
	public void close() {
		try {
			commandStream.close();
		} catch (IOException e) {
		}
	}

	/**
	 * 
	 * Returns the value of the command that has been specified.
	 * 
	 * @return Returns the command that was parsed in the form of a CmdForm.
	 */
	public CmdForm getCurrentCommand() {
		if (currCommand.contentEquals("show_name")) {
			return CmdForm.SHOW_NAME;
		} else if (currCommand.contentEquals("show_latitude")) {
			return CmdForm.SHOW_LATITUDE;
		} else if (currCommand.contentEquals("show_longitude")) {
			return CmdForm.SHOW_LONGITUDE;
		} else if (currCommand.contentEquals("show_elevation")) {
			return CmdForm.SHOW_ELEVATION;
		} else if (currCommand.contentEquals("quit")) {
			return CmdForm.QUIT;
		}
		// This case is never implemented as our command file contains commands.
		else {
			return CmdForm.INVALID_CMD;
		}
	}

	/**
	 * A method that defines a loop that parses through commands in the GIS commands
	 * file. It breaks if it finds that an offset occurs at for the command.
	 */
	public void parseCmd() {
		while (true) {
			String cmd = null;
			try {
				cmd = commandStream.readLine();
			} catch (IOException e) {
				System.err.println("When reading file I/O error occured.");
				System.exit(1);
			}

			if (cmd.contains(";") || cmd == null)
				continue;

			Scanner cmdScanner = new Scanner(cmd);

			// Parsing the command and seeing if the offset is available
			currCommand = cmdScanner.next();
			if (cmdScanner.hasNextLong()) {
				currOffset = cmdScanner.nextLong();
				checkOffset = true;
			} else
				checkOffset = false;
			cmdScanner.close();

			break;
		}
	}

	/**
	 * The method returns the currentOffset.
	 * 
	 * @return Returns the current offset that is read by the current line.
	 * 
	 */
	public long getCurrentOffset() {
		return currOffset;
	}

	/**
	 * Overwritting the toString method to align the text in the file correctly.
	 * 
	 * @return Returns a string representing the current command and the current
	 *         offset.
	 */
	public String toString() {
		if (checkOffset)
			return currCommand + "\t" + currOffset;
		else
			return currCommand;

	}

}

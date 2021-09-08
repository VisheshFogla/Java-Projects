

//  Project 1 for CS 3114 Spring 2021
//
//  Programmer:    Vishesh Fogla
//  OS:            Windows 2010 
//  System:        i5 7th gen, 1 TB Memory
//  Last modified: February 3, 2021


import java.io.File;
import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Formatter;
import java.io.IOException;

/**
 * 
 * A class that parses the offsets through indexing returns the values of offsets.
 * 
 * @author Vishesh
 *
 */
public class indexParser {

	/**
	 * @param gisStream stream to access the gisFile.
	 */
	public RandomAccessFile gisStream;

	/**
	 * Constructor that defines the Parser ad its parameters.
	 * 
	 * @param gisFile The file that contains GIS data.
	 */
	public indexParser(File gisFile) {
		try {
			gisStream = new RandomAccessFile(gisFile, "r");
		} catch (FileNotFoundException e) {
			System.err.println("File" + gisFile.getName() + "could not be found");
			System.exit(1);
		}
	}

	/**
	 * Fetches the Feature ID of the given record or offset.
	 * 
	 * @param offset whose feature ID is required.
	 * @return A string that contains the feature ID of the offset.
	 */
	public String getFeatureID(long offset) {
		return getValue(offset, OffsetForm.FEATURE_ID);
	}

	/**
	 * Fetches the Elevation of the given record or offset
	 * 
	 * @param offset whose elevation is required.
	 * @return A string that contains the elevation of the offset
	 */
	public String getElevation(long offset) {
		String elevation = getValue(offset, OffsetForm.ELEV_IN_F);
		if (elevation.length() > 0)
			return elevation;
		else
			return "Elevation is not given";
	}

	/**
	 * Fetches the Feature Name of the given record or offset
	 * 
	 * @param offset whose feature name is required.
	 * @return A string that contains the feature name of the offset
	 */
	public String getFeatureName(long offset) {
		return getValue(offset, OffsetForm.FEATURE_NAME);
	}

	/**
	 * Fetches the latitude of the given record or offset
	 * 
	 * @param offset whose latitude is required.
	 * @return A string that contains the latitude of the offset
	 */
	public String getLatitude(long offset) {
		String latitude = getValue(offset, OffsetForm.PRIM_LAT_DMS);
		if (latitude.contains(" "))
			return latitude;
		else
			return changeIntoDMS(latitude);
	}

	/**
	 * Fetches the Longitude of the given record or offset
	 * 
	 * @param offset whose Longitude is required.
	 * @return A string that contains the Longitude of the offset
	 */
	public String getLongitude(long offset) {
		String longitude = getValue(offset, OffsetForm.PRIM_LONG_DMS);
		if (longitude.contains(" "))
			return longitude;
		else
			return changeIntoDMS(longitude);
	}

	/**
	 * Closes the gisStream.
	 */
	public void close() {
		try {
			gisStream.close();
		} catch (IOException e) {
		}
	}

	/**
	 * A function that extracts the required offset that is specified by the
	 * command.
	 * 
	 * @param offset  Begins at the start of the record and keeps increasing until
	 *                it reaches the required one
	 * @param request The value that the command wants.
	 * @return A string that stores the required value for the command.
	 * 
	 */
	private String getValue(long offset, OffsetForm request) {

		String value = null;

		try {
			// Various cases if the offset if not proper
			if (offset < 0)
				return "Offset is not positive";
			if (offset == 0)
				return "Offset is unaligned";
			if (offset >= gisStream.length())
				return "Offset is too large";
			if (!validOffset(offset))
				return "Offset is unaligned";

			gisStream.seek(offset);
			value = gisStream.readLine();

		} catch (IOException e) {
			System.err.println("When reading file I/O error occured.");
			System.exit(1);
		}

		// returns to large offset if the record does not exist.
		if (value == null)
			return "Offset is too large";

		Scanner parser = new Scanner(value);
		parser.useDelimiter("\\|");

		// Loop that takes through the record and stops at the value that is required by
		// the command, this is also what ordinal method achieves.

		for (int i = -1; i < request.ordinal(); i++) {
			if (parser.hasNext()) {
				value = parser.next();
			}
		}

		parser.close();

		// checks if the longitudes and latitudes are given as Unknown or 0

		if (value.contentEquals("Unknown") || value.contentEquals("0")) {
			return "Coordinate is not given";
		}

		return value;
	}
	
	/**
	 * A function that changes the numeric value of longitudes and latitudes to dms format.
	 * 
	 * @param coordinate the longitude or latitude of the offset
	 * @return returns the modified string indicating the direction as well..
	 */
	private String changeIntoDMS(String coordinate) {
		int s, m, d;
		String dir, sec, mins, degs;
		int size = coordinate.length();

		sec = coordinate.substring(size - 3, size - 1);
		mins = coordinate.substring(size - 5, size - 3);
		degs = coordinate.substring(0, size - 5);
		dir = coordinate.substring(size - 1);

		// removing leading zeros
		s = Integer.parseInt(sec);
		m = Integer.parseInt(mins);
		d = Integer.parseInt(degs);

		if (dir.equals("N")) {
			dir = "North";
		} else if (dir.contentEquals("S")) {
			dir = "South";
		} else if (dir.contentEquals("W")) {
			dir = "West";
		} else if (dir.contentEquals("E")) {
			dir = "East";
		}

		Formatter modify = new Formatter();

		modify.format("%dd %dm %ds %s", d, m, s, dir);
		String update = modify.toString();
		modify.close();

		return update;
	}


	/**
	 * A function that checks if the offset exists or not and returns a boolean
	 * value.
	 * 
	 * @param offset to be checked if it is valid or not.
	 * @return Returns if the offset does not start at the beginning of the line
	 *         then returns false otherwise returns true.
	 */
	private boolean validOffset(long offset) {
		char c = '\0';

		try {
			gisStream.seek(offset - 1);
			c = (char) gisStream.readByte();
		} catch (IOException e) {
			System.err.println("When reading file I/O error occured");
			System.exit(1);
		}

		if (c == '\n')
			return true;
		else
			return false;
	}
	
}

	
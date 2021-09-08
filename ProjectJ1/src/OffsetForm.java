
//  Project 1 for CS 3114 Spring 2021
//
//  Programmer:    Vishesh Fogla
//  OS:            Windows 2010 
//  System:        i5 7th gen, 1 TB Memory
//  Last modified: February 3, 2021


/**
 * 
 * @author Vishesh
 * @param OffsetForm An enumerated type illustrating the format of each
 *                   identical record in the file that contains the GIS data.
 */
public enum OffsetForm {
	FEATURE_ID, FEATURE_NAME, FEATURE_CLASS, STATE_ALPHA_, STATE_NUM_, COUNTY_NAME, COUNTY_NUMERIC, PRIM_LAT_DMS,
	PRIM_LONG_DMS, PRIM_LAT, PRIM_LONG, SRC_LAT_DMS, SRC_LONG_DMS, SRC_LAT, SRC_LONG, ELEV_IN_M, ELEV_IN_F, MAP_NAME,
	DATE_CREATED, DATE_EDITED;
}

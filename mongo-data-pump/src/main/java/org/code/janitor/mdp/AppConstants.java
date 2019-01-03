package org.code.janitor.mdp;

public interface AppConstants  {
	public String[] INPUT_FILE_HEADERS= {
			"id",   /*ID*/
			"caseNo", /*CASE_NUMBER*/
			"date",/*DATE "10/20/10 3:15"*/
			"block", /*BLOCK*/
			"icur", /*IUCR*/
			"primaryType", /*PRIMARY_TYPE*/
			"description", /*DESCRIPTION*/
			"locationDescription", /*LOCATION_DESCRIPTION*/
			"arrest", /*ARREST*/
			"domestic", /*DOMESTIC*/
			"beat", /*BEAT*/
			"district", /*DISTRICT*/
			"ward", /*WARD*/
			"communityArea", /*COMMUNITY_AREA*/
			"fbiCode", /*FBI_CODE*/
			"xCoordinate", /*X_COORDINATE*/
			"yCoordinate", /*Y_COORDINATE*/
			"year", /*YEAR*/
			"updatedOn", /*UPDATED_ON*/
			"latitude", /*LATITUDE*/
			"longitude", /*LONGITUDE*/
			"location" /*LOCATION*/	
			
			
			
	};
	
	public int READ_CHUNK_SIZE= 100;
	public String INPUT_FILE_PATTERN = "*.csv";
	

}
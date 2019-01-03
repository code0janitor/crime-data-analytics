package org.code.janitor.mdp.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Incident implements Serializable{

	private static final long serialVersionUID = 8786375425719297041L;
	public static String DATE_FORMAT = "MM/dd/yy hh:mm";

	/*{ 
		  "id":"7764842",
		  "caseNo":"HS573041",
		  "date":"10/20/10 3:15",
		  "icur":"1330",
		  "primaryType": "CRIMINAL TRESPASS",
		  "description":"TO LAND",
		  "locationDescription":"RESIDENTIAL YARD (FRONT/BACK)",
		  "arrest":"TRUE",
		  "domestic":"FALSE",
		  "beat":"324",
		  "fbiCode":"26",
		  "year":"2010",
		  "updatedOn":"2/4/16 6:33",
		  address....
		  
		  }
		  */
	
	
	
	private long id;   /*ID*/
	private String caseNo; /*CASE_NUMBER*/
	private long date; /*DATE "10/20/10 3:15"*/
	private String dateAsString;
	private String icur; /*IUCR*/
	private String primaryType; /*PRIMARY_TYPE*/
	private String description; /*DESCRIPTION*/
	private String locationDescription; /*LOCATION_DESCRIPTION*/
	private String arrest; /*ARREST*/
	private String domestic; /*DOMESTIC*/
	private String fbiCode; /*FBI_CODE*/
	private int year; /*YEAR*/
	private long updatedOn; /*UPDATED_ON*/
	private String updatedOnAsString; /*UPDATED_ON*/
	private Address address;
	private PoliceEnforcement policeEnforcement;
	

	
	//Sync Tracking Fields
	private String syncNeo4j="PENDING";
	private String syncElastic="PENDING";
	private String syncInflux = "PENDING";
	
	
	
	
	public static String getDATE_FORMAT() {
		return DATE_FORMAT;
	}


	public static void setDATE_FORMAT(String dATE_FORMAT) {
		DATE_FORMAT = dATE_FORMAT;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCaseNo() {
		return caseNo;
	}


	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}


	public long getDate() {
		return date;
	}


	public void setDate(long date) {
		this.date = date;
	}


	public String getDateAsString() {
		return dateAsString;
	}


	public void setDateAsString(String dateAsString) {
		this.dateAsString = dateAsString;
	}


	public String getIcur() {
		return icur;
	}


	public void setIcur(String icur) {
		this.icur = icur;
	}


	public String getPrimaryType() {
		return primaryType;
	}


	public void setPrimaryType(String primaryType) {
		this.primaryType = primaryType;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getLocationDescription() {
		return locationDescription;
	}


	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}


	public String getArrest() {
		return arrest;
	}


	public void setArrest(String arrest) {
		this.arrest = arrest;
	}


	public String getDomestic() {
		return domestic;
	}


	public void setDomestic(String domestic) {
		this.domestic = domestic;
	}


	public String getFbiCode() {
		return fbiCode;
	}


	public void setFbiCode(String fbiCode) {
		this.fbiCode = fbiCode;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public long getUpdatedOn() {
		return updatedOn;
	}


	public void setUpdatedOn(long updatedOn) {
		this.updatedOn = updatedOn;
	}


	public String getUpdatedOnAsString() {
		return updatedOnAsString;
	}


	public void setUpdatedOnAsString(String updatedOnAsString) {
		this.updatedOnAsString = updatedOnAsString;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public PoliceEnforcement getPoliceEnforcement() {
		return policeEnforcement;
	}


	public void setPoliceEnforcement(PoliceEnforcement policeEnforcement) {
		this.policeEnforcement = policeEnforcement;
	}

	
	public String getSyncNeo4j() {
		return syncNeo4j;
	}


	public void setSyncNeo4j(String syncNeo4j) {
		this.syncNeo4j = syncNeo4j;
	}


	public String getSyncElastic() {
		return syncElastic;
	}


	public void setSyncElastic(String syncElastic) {
		this.syncElastic = syncElastic;
	}


	public String getSyncInflux() {
		return syncInflux;
	}


	public void setSyncInflux(String syncInflux) {
		this.syncInflux = syncInflux;
	}


	@Override
	public String toString() {
		return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}

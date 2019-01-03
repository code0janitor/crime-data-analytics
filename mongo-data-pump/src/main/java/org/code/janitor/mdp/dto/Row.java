package org.code.janitor.mdp.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Row implements Serializable {

	
	private static final long serialVersionUID = 3268552311909935329L;
	@Id
	private String id;   /*ID*/
	private String caseNo; /*CASE_NUMBER*/
	private String date;/*DATE "10/20/10 3:15"*/
	private String icur; /*IUCR*/
	private String primaryType; /*PRIMARY_TYPE*/
	private String description; /*DESCRIPTION*/
	private String locationDescription; /*LOCATION_DESCRIPTION*/
	private String arrest; /*ARREST*/
	private String domestic; /*DOMESTIC*/
	private String fbiCode; /*FBI_CODE*/
	private String year; /*YEAR*/
	private String updatedOn; /*UPDATED_ON*/
	private String beat; /*BEAT*/
	private String communityArea; /*COMMUNITY_AREA*/
	private String block; /*BLOCK*/
	private String ward; /*WARD*/
	private String district; /*DISTRICT*/
	private String xCoordinate; /*X_COORDINATE*/
	private String yCoordinate; /*Y_COORDINATE*/
	private String latitude; /*LATITUDE*/
	private String longitude; /*LONGITUDE*/
	private String location; /*LOCATION*/
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
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
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getBeat() {
		return beat;
	}
	public void setBeat(String beat) {
		this.beat = beat;
	}
	public String getCommunityArea() {
		return communityArea;
	}
	public void setCommunityArea(String communityArea) {
		this.communityArea = communityArea;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(String xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public String getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(String yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}

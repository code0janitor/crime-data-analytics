package org.code.janitor.mdp.dto;

import java.io.Serializable;


public class PoliceEnforcement implements Serializable {

	private static final long serialVersionUID = -125268365942325594L;

	
	private String beat; /*BEAT*/
	private String sector; /*SECTOR*/
	private String district; /*DISTRICT*/
	
	public String getBeat() {
		return beat;
	}
	public void setBeat(String beat) {
		this.beat = beat;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	

}

package org.code.janitor.mdp.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.code.janitor.mdp.dto.Address;
import org.code.janitor.mdp.dto.Incident;
import org.code.janitor.mdp.dto.Location;
import org.code.janitor.mdp.dto.PoliceEnforcement;
import org.code.janitor.mdp.dto.Row;
import org.springframework.batch.item.ItemProcessor;

public class ConvertProcessor implements ItemProcessor<Row,Incident>
{
	@Override
    public Incident process(Row row) throws Exception
    {
            Incident incident = convert(row);
            return incident;
    }
    
    
    /**
     * TODO: Use MapStruct later
     * @param row
     * @return Incident
     */
    
    private Incident convert(final Row row)
    {
    	/* Prepare Location Object */
		/* 
			Assumtions
			1. When the location LATITUDE or LONGITUDE or both is not present set it to ZERO '0.0F'
			2. When the location Y_COORDINATE or X_COORDINATE or both is not present set it to ZERO '0'
		
			Stupid works --- duh  yes ... :)
			
		  "location":
		            {
		                "xCoordinate":"1189209",
		                "yCoordinate":"1857587",
		                "latitude":"41.76427307",
		                "longitude":"-87.58205731",
		                "location":"(41.764273074, -87.582057311)"
		            }
		*/
		
		Location location = new Location();
		
		location.setLocation(row.getLocation());
		try {
			float latitude = Float.valueOf(row.getLatitude());
			location.setLatitude(latitude);
		} catch (Exception E) {
			location.setLatitude(0.00F);
		}
		try {
			float longitude = Float.valueOf(row.getLongitude());
			location.setLongitude(longitude);
		} catch (Exception E) {
			location.setLongitude(0.00F);
		}
		try {
			long xCoordinate = Long.valueOf(row.getxCoordinate());
			location.setxCoordinate(xCoordinate);
		} catch (Exception E) {
			location.setxCoordinate(0);
		}
    	
		try {
			long yCoordinate = Long.valueOf(row.getyCoordinate());
			location.setyCoordinate(yCoordinate);
		} catch (Exception E) {
			location.setyCoordinate(0);
		}
    	

		/* prepare Address 
		  "address":
		    {
		        "communityArea":"43",
		        "block":"017XX E 72ND ST",
		        "ward":"5",
		        "district":"3",
		     location...   
		       
		    }
		 */
		Address address = new Address();
		address.setBlock(row.getBlock());
		address.setCommunityArea(row.getCommunityArea());
		address.setDistrict(row.getDistrict());
		address.setWard(row.getWard());
		address.setLocation(location);
		
		
		/* prepare PoliceEnforcement 
		  "PoliceEnforcement":
		    {
		        "beat":"139",
		        "sector":"3",
		        "district":"1",
		       
		    }
		 */
		
		PoliceEnforcement enforcement = new PoliceEnforcement();
		
		try
		{
			/*Convert the beat number to 4 digit*/
			String beatNumber = StringUtils.leftPad(row.getBeat(), 4, "0");
			enforcement.setBeat(beatNumber);
			enforcement.setDistrict(StringUtils.substring(beatNumber, 0, 2)  );
			enforcement.setSector(StringUtils.substring(beatNumber, 2,3)  );
    	} catch (Exception E) 
    	{
    	}
		
		
		/*
		 		{ 
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
				  enforcement...
			  
			  }
		  */
			
		Incident incident = new Incident();
		
		
		
		// prepare Incident
		incident.setArrest(row.getArrest());
		incident.setCaseNo(row.getCaseNo());
		
		
		try {
			long id = Long.valueOf(row.getId());
			incident.setId(id);
		} catch (Exception E) {
		}
		
		try 
		{
			Date caseDate = new SimpleDateFormat(Incident.DATE_FORMAT).parse(row.getDate());
			incident.setDate(caseDate.getTime());
		
		} catch (Exception E) {
		}
		incident.setDateAsString(row.getDate());
		try 
		{
			Date updatedOn = new SimpleDateFormat(Incident.DATE_FORMAT).parse(row.getUpdatedOn());
			incident.setUpdatedOn(updatedOn.getTime());
		
		} catch (Exception E) {
		}
		incident.setUpdatedOnAsString(row.getUpdatedOn());
		
		try {
			int year = Integer.valueOf(row.getYear());
			incident.setYear(year);
		} catch (Exception E) {
		}
		
		
		incident.setDescription(row.getDescription());
		incident.setDomestic(row.getDomestic());
		incident.setFbiCode(row.getFbiCode());
		incident.setIcur(row.getIcur());
		
		incident.setLocationDescription(row.getLocationDescription());
		incident.setPrimaryType(row.getPrimaryType());
		
		incident.setAddress(address);
		incident.setPoliceEnforcement(enforcement);
		
		
		
		return incident;
		
    }
    
    
    
    
    
    
    
    
}
**To provide a platform for data aggregation for both exploratory and statistical analytics on crime data. The main idea to build this project to:**
1. Build a data ingestion layer for crime incedents
2. Build grapph model for:
   - 2.1 exploratory analysis
   - 2.2 crime profile modeling using a model close POLE modeling
3. Build analytics and dashboard
4. Build police coverage needs [to beat, sector & district] prediction on hostorical data
5. Build crime based [date & time based] routing  on hostorical data

**Tools & Data sets:**
1.  Data: 		      https://www.data.gov
2. 	Neo4j:		      https://neo4j.com
3. 	ElasticSearch: 	https://www.elastic.co
4. 	Kibana:		      https://www.elastic.co
5.  MongoDB:        https://www.mongodb.com
6.  Dockers:        https://www.docker.com 


**Data Dictionary:**

This dataset holds the reported incidents of crime (with the exception of murders where data exists for each victim) that occurred in the City of Chicago from 2001 to present, minus the most recent seven days. Data is extracted from the Chicago Police Department's CLEAR (Citizen Law Enforcement Analysis and Reporting) system. In order to protect the privacy of crime victims, addresses are shown at the block level only and specific locations are not identified.

### What's in this Dataset?
1. Rows:           ~6.5 Million
2. Columns:        22

### Dataset Meta-Data

| Name | Description | Type |
| --- | --- | --- |
| ID | Unique identifier for the record. | Number |
| Case Number | The Chicago Police Department RD Number (Records Division Number), which is unique to the incident. | Plain Text |
| Date | Date when the incident occurred. this is sometimes a best estimate. | Date &amp; Time |
| Block | The partially redacted address where the incident occurred, placing it on the same block as the actual address. | Plain Text |
| IUCR | The Illinois Uniform Crime Reporting code. This is directly linked to the Primary Type and Description. See the list of IUCR codes at [https://data.cityofchicago.org/d/c7ck-438e](https://data.cityofchicago.org/d/c7ck-438e) | Plain Text |
| Primary Type | The primary description of the IUCR code. | Plain Text |
| Description | The secondary description of the IUCR code, a subcategory of the primary description. | Plain Text |
| Location Description | Description of the location where the incident occurred. | Plain Text |
| Arrest | Indicates whether an arrest was made. | Checkbox |
| Domestic | Indicates whether the incident was domestic-related as defined by the Illinois Domestic Violence Act. | Checkbox |
| Beat | Indicates the beat where the incident occurred. A beat is the smallest police geographic area – each beat has one dedicated police beat car. Three to five beats make up a police sector, and three sectors make up a police district. The Chicago Police Department has 22 police districts. See the beats at [https://data.cityofchicago.org/d/aerh-rz74](https://data.cityofchicago.org/d/aerh-rz74) | Plain Text |
| District | Indicates the police district where the incident occurred. See the districts at [https://data.cityofchicago.org/d/fthy-xz3r](https://data.cityofchicago.org/d/fthy-xz3r) | Plain Text |
| Ward | The ward (City Council district) where the incident occurred. See the wards at [https://data.cityofchicago.org/d/sp34-6z76](https://data.cityofchicago.org/d/sp34-6z76). | Number |
| Community Area | Indicates the community area where the incident occurred. Chicago has 77 community areas. See the community areas at [https://data.cityofchicago.org/d/cauq-8yn6](https://data.cityofchicago.org/d/cauq-8yn6). | Plain Text |
| FBI Code | Indicates the crime classification as outlined in the FBI&#39;s National Incident-Based Reporting System (NIBRS). See the Chicago Police Department listing of these classifications at [http://gis.chicagopolice.org/clearmap\_crime\_sums/crime\_types.html](http://gis.chicagopolice.org/clearmap_crime_sums/crime_types.html). | Plain Text |
| X Coordinate | The x coordinate of the location where the incident occurred in State Plane Illinois East NAD 1983 projection. This location is shifted from the actual location for partial redaction but falls on the same block. | Number |
| Y Coordinate | The y coordinate of the location where the incident occurred in State Plane Illinois East NAD 1983 projection. This location is shifted from the actual location for partial redaction but falls on the same block. | Number |
| Year | Year the incident occurred. | Number |
| Updated On | Date and time the record was last updated. | Date &amp; Time |
| Latitude | The latitude of the location where the incident occurred. This location is shifted from the actual location for partial redaction but falls on the same block. | Number |
| Longitude | The longitude of the location where the incident occurred. This location is shifted from the actual location for partial redaction but falls on the same block. | Number |
| Location | The location where the incident occurred in a format that allows for creation of maps and other geographic operations on this data portal. This location is shifted from the actual location for partial redaction but falls on the same block. | Location |

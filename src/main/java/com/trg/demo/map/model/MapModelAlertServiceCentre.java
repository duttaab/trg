/**
* The MapModelAlertServiceCentre is concrete class to provide
* data definition and access methods for MAP-ALERT-SERVICE-CENTRE request.
* 
* 
* @author  Abhijit Dutta
* @version 1.0
* @since   2020-08-31 
*/

package com.trg.demo.map.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MapModelAlertServiceCentre extends MapModel {

	private final int opcode;
	private final String sca;
	private final String msisdn;
	private String ecodedbytes;
	
	public MapModelAlertServiceCentre(@JsonProperty("msisdn")   String msisdn, 
			                          @JsonProperty("opcode")   int opcode,
			                          @JsonProperty("sca")      String sca) {
		
		this.opcode = opcode;
		this.msisdn = msisdn;
		
		// Optional parameter 
		this.sca = sca;
	
	}

	public int getOpcode() {
		return opcode;
	}

	public String getSca() {
		return sca;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public String getEncodedBytes() {
		return ecodedbytes;
	}
	
	public void setEncodedData(String data) {
		this.ecodedbytes = data;
	}
}

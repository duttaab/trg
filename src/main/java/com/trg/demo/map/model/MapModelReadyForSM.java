/**
* The MapModelReadyForSM is concrete class to provide
* data definition and access methods for MAP-READY-FOR-SM request.
* 
* 
* @author  Abhijit Dutta
* @version 1.0
* @since   2020-08-31 
*/
package com.trg.demo.map.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MapModelReadyForSM extends MapModel {

	private final String alertReason;
	private final String imsi;
	private String ecodedbytes;
	
	public MapModelReadyForSM(@JsonProperty("imsi")          String imsi, 
                              @JsonProperty("alertreason")   String alert) {

		this.alertReason = alert;
		//Optional parameter
        this.imsi = imsi;
    }

	public String getAlertReason() {
		return alertReason;
	}

	public String getImsi() {
		return imsi;
	}

	public String getEncodedBytes() {
		return ecodedbytes;
	}

	public void setEncodedData(String ecodedbytes) {
		this.ecodedbytes = ecodedbytes;
	}
}

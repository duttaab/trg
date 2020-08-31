/**
* The CustomMessageHandler defines a construct to propagate custom
* exception message and HTTP error codes.
* 
* 
* @author  Abhijit Dutta
* @version 1.0
* @since   2020-08-31 
*/

package com.trg.demo.map.apierror;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomMessageHandler {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	private String api;
	private String httpCodeMessage;

	public CustomMessageHandler (LocalDateTime timestamp, 
			                     String message, 
			                     String api,
			                     String httpCodeMessage) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.api = api;
		this.httpCodeMessage=httpCodeMessage;
	}

	public String getHttpCodeMessage() {
		return this.httpCodeMessage;
	}

	public LocalDateTime getTimestamp() {
		return this.timestamp;
	}

	public String getMessage() {
		return this.message;
	}

	public String getApi() {
		return this.api;
	}
}

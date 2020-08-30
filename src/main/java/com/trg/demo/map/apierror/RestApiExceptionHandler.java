/**
* The RestApiExceptionHandler is an extension to the Sprint Boot
* Exception handler to propagate custom exception.
* 
* 
* @author  Abhijit Dutta
* @version 1.0
* @since   2020-08-31 
*/

package com.trg.demo.map.apierror;

import org.springframework.http.HttpStatus;

public class RestApiExceptionHandler extends RuntimeException  {
	
	private static final long serialVersionUID = 1L;
	HttpStatus status;

	public RestApiExceptionHandler(String message, HttpStatus status) {
		super(message);
		
		this.status = status;
	}
	
	HttpStatus getStatus() {
		return status;
	}
}

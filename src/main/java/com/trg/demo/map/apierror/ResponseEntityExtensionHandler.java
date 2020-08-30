/**
* The ResponseEntityExtensionHandler is a way to provide a common
* error response strategy for the controller module.
* 
* @author  Abhijit Dutta
* @version 1.0
* @since   2020-08-31 
*/

package com.trg.demo.map.apierror;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ResponseEntityExtensionHandler extends ResponseEntityExceptionHandler  {

	@ExceptionHandler(RestApiExceptionHandler.class)
	public final ResponseEntity<CustomMessageHandler> 
	    handleNotFoundException(RestApiExceptionHandler ex, WebRequest request) {
		     CustomMessageHandler exceptionResponse = 
		    		  new CustomMessageHandler(LocalDateTime.now(), 
		    				                   ex.getMessage(),
				                               request.getDescription(false),
				                               ex.getStatus().getReasonPhrase());
				                               
		
		       return new ResponseEntity<CustomMessageHandler>(exceptionResponse, 
		    		                                           ex.getStatus());
	}
	
	@Override
	public ResponseEntity<Object> 
	    handleHttpMessageNotReadable(HttpMessageNotReadableException ex, 
	    	                         HttpHeaders headers, 
	    		                     HttpStatus status, 
	    		                     WebRequest request) {
		  
		     String message = "Malformed JSON";
		     CustomMessageHandler exceptionResponse = 
		    		  new CustomMessageHandler(LocalDateTime.now(), 
		    				                   message,
				                               request.getDescription(false),
				                               status.getReasonPhrase());
				                               
		
		     return new ResponseEntity<Object>(exceptionResponse, status);
		}
}

/**
* The MapAlertEndpointController provides API end-point
* to process MAP-ALERT-SERVICE-CENTRE request.
* Controller calls Service to further process the requests.
* 
* Rest API - POST (JSON request/response)
* 
* @author  Abhijit Dutta
* @version 1.0
* @since   2020-08-31 
*/

package com.trg.demo.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trg.demo.map.apierror.MapMessageException;
import com.trg.demo.map.apierror.RestApiExceptionHandler;
import com.trg.demo.map.model.MapModelAlertServiceCentre;
import com.trg.demo.map.service.ProcessMapAlertServiceCenter;

@RequestMapping("map/alertservice/v3")
@RestController
public class MapAlertEndpointController {
	
	private final ProcessMapAlertServiceCenter alertService;
	
	@Autowired 
	public MapAlertEndpointController(ProcessMapAlertServiceCenter alertService) {
		this.alertService = alertService;
	}
	
	@PostMapping
	@ResponseBody
	public MapModelAlertServiceCentre process(@RequestBody MapModelAlertServiceCentre params) {
		try {
			this.alertService.validateMapParameter(params);
			this.alertService.encode();
		}
		catch (MapMessageException ex) {
			throw new RestApiExceptionHandler(ex.getMessage(), HttpStatus.BAD_REQUEST);
			
		} catch (Exception e) {
			throw new RestApiExceptionHandler(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return params;
	}
}

/**
* The MapReadyForSMController provides API end-point
* to process MAP-READY-FOR-SM request.
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
import com.trg.demo.map.model.MapModelReadyForSM;
import com.trg.demo.map.service.ProcessReadyForSM;

@RequestMapping("map/readyforsm/v3")
@RestController
public class MapReadyForSMController {
	
	private final ProcessReadyForSM readyService;
	
	@Autowired 
	public MapReadyForSMController(ProcessReadyForSM readyService) {
		this.readyService = readyService;
	}
	
	@PostMapping
	@ResponseBody
	public MapModelReadyForSM process(@RequestBody MapModelReadyForSM params) {
		try {
			this.readyService.validateMapParameter(params);
			this.readyService.encode();
		}
		catch (MapMessageException ex) {
			throw new RestApiExceptionHandler(ex.getMessage(), HttpStatus.BAD_REQUEST);
			
		} catch (Exception e) {
			throw new RestApiExceptionHandler(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return params;
	}
}

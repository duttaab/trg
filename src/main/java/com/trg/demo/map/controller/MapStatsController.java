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

import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trg.demo.map.apierror.MapMessageException;
import com.trg.demo.map.apierror.RestApiExceptionHandler;
import com.trg.demo.map.model.MapModelAlertServiceCentre;
import com.trg.demo.map.model.MapStatsModel;
import com.trg.demo.map.service.ProcessMapAlertServiceCenter;
import com.trg.demo.map.service.ProcessMapMessage;
import com.trg.demo.map.service.ProcessReadyForSM;

@RequestMapping("map/stats/v3")
@RestController
public class MapStatsController {
	
	private final ProcessReadyForSM service;
	
	@Autowired 
	public MapStatsController(ProcessReadyForSM service) {
		this.service = service;
	}
	
	@GetMapping
	public TreeMap<String, MapStatsModel>  getStats() {
		
		System.out.println("GET Method Called");
	    return this.service.getStats();

	}
}

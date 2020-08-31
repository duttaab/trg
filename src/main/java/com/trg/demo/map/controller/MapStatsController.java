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

import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.trg.demo.map.model.MapStatsModel;
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
	    return this.service.getStats();
	}
}

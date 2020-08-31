/**
* The DAO interface for in memory DB for MAP request Statistics.
* 
* @author  Abhijit Dutta
* @version 1.0
* @since   2020-08-31 
*/

package com.trg.demo.map.dao;

import java.util.TreeMap;

import com.trg.demo.map.model.MapStatsModel;

public interface MapStatsDao {
	
	enum MapMessageId 
	{ 
		MAPREADYFORSM, 
		MAPALERTSERVICECENTRE; 
	} 
	
	enum Operation
	{
		SUCCESS,
		FAILED;
	}
	
    
    public void setError();
    public void setSuccess();
 	public Operation updateStats(MapMessageId id);
	public TreeMap<String, MapStatsModel> getStats();
}

/**
* The DAO class for in memory DB for MAP request Statistics.
* 
* 
* @author  Abhijit Dutta
* @version 1.0
* @since   2020-08-31 
*/
package com.trg.demo.map.dao;

import java.util.TreeMap;

import org.springframework.stereotype.Repository;
import com.trg.demo.map.model.MapStatsModel;

@Repository("MemDB")
public class MapInMemStats implements MapStatsDao {

	static TreeMap<String, MapStatsModel> tree_map;
	boolean bSetError =  false;
	boolean bSetSuccess =  false;
    
    MapInMemStats() {
    	tree_map = new TreeMap<String, MapStatsModel>();
    }
    
    public void setError() {
    	bSetError = true;
    }
    
    public void setSuccess() {
    	bSetSuccess = true;
    }
    
    private void resetIndicators() {
    	this.bSetError = false;
    	this.bSetSuccess = false;
    }
    
	@Override
	public Operation updateStats(MapMessageId id) {
		MapStatsModel element = tree_map.get(id.name());
		
		if (element == null) {
			element = new MapStatsModel();
		}
						
		if (this.bSetError)
			element.incrNumErrors();
		if (this.bSetSuccess)
			element.incrNumSuccess();
		
		element.setNumRequests(element.getFailed()+element.getSuccess());
		
		tree_map.put(id.name(), element);

		resetIndicators();
		
		return Operation.SUCCESS;
	}
	
	public TreeMap<String, MapStatsModel> getStats() {
		return tree_map;
	}

}

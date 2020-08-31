/**
* The Data model for MAP Statistics.
* 
* @author  Abhijit Dutta
* @version 1.0
* @since   2020-08-31 
*/
package com.trg.demo.map.model;


public class MapStatsModel {
	
	private int    numrequests;
	private int    numsuccess;
	private int    numerrors;
	
    public MapStatsModel() {
    	this.numrequests = 0;
    	this.numsuccess = 0;
    	this.numerrors = 0;
    }
    
    public void incrNumSuccess() {
    	++this.numsuccess;
    }
    
    public void incrNumErrors() {
    	++this.numerrors;
    }
    
    public void setNumRequests(int n) {
    	numrequests = n;
    }
    
    public void setFailed(int n) {
    	this.numerrors += n;
    }
    
    public void setSuccess(int n) {
    	this.numsuccess += n;
    }
        
    public int getNoOfRequests() {
    	return this.numrequests;
    }
    
    public int getFailed() {
    	return this.numerrors;
    }
    
    public int getSuccess() {
    	return this.numsuccess;
    }
}

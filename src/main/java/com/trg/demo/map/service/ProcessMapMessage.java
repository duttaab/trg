/**
* The ProcessMapMessage is an abstract class for all MAP message
* processors which describes the minimum set of methods to be 
* implemented.
* 
* @author  Abhijit Dutta
* @version 1.0
* @since   2020-08-31 
*/

package com.trg.demo.map.service;

import com.trg.demo.map.apierror.MapMessageException;
import com.trg.demo.map.model.MapModel;

public abstract class ProcessMapMessage {

	/** Function to check the sanity of the MAP parameters */
	abstract void validateMapParameter(MapModel m) throws MapMessageException;
	
	/** Function to encode MAP message. Uses jSS7 library function. 
	 * @throws Exception **/
	abstract void encode()  throws Exception;
	
	/** Function to decode MAP message Uses jSS7 library function. 
	 * * @throws Exception **/
	abstract void  decoder() throws Exception;
	
	static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
	
	/** Utility function to convert hex bytes to string **/
	public String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for (int j = 0; j < bytes.length; j++) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = HEX_ARRAY[v >>> 4];
	        hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
	    }
	    
	    String str = new String();
	    for (int i=0; i<hexChars.length;i++) {
	    	if (i%2 == 0)
	    		str += " 0x";
	    	str += hexChars[i];
	    }
	    
	    return (str.trim());
	}
}

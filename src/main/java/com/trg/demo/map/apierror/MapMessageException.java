/**
* The MapMessageException is an extension to the generic Exception
* to handle MAP parameter validation.
* 
* @author  Abhijit Dutta
* @version 1.0
* @since   2020-08-31 
*/

package com.trg.demo.map.apierror;

public class MapMessageException extends Exception {

	private static final long serialVersionUID = 1L;

	public MapMessageException(String str) {
		super(str);
	}
}

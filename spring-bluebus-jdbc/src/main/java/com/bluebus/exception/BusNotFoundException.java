package com.bluebus.exception;

public class BusNotFoundException extends Exception {

	/**
	 * functionality - throws BusNotFound Exception
	 */
	private static final long serialVersionUID = 1L;
	
	public BusNotFoundException() {
		super();
	}
	
	public BusNotFoundException(String message) {
		super(message);
	}
	

}

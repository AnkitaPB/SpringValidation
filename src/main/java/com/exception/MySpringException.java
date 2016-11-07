package com.exception;

public class MySpringException extends Exception  {
	private String errorMessages;

	public String getErrorMessages() {
		return errorMessages;
	}

		public void setErrorMessages(String errorMessages) {
		this.errorMessages = errorMessages;
	}


	public MySpringException(String errorMessages) {
	//	super();
		this.errorMessages = errorMessages;
	}

	
	

}

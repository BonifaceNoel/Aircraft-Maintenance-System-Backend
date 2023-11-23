package com.ibsplc.his.api_his_project.exceptions;

@SuppressWarnings("serial")
public class NewFlightException extends Exception{

	public NewFlightException() {
		super();
	}
	public NewFlightException(String error) {
		super(error);
	}
	public NewFlightException(String error, Throwable cause) {
		super(error, cause);
	}
	public NewFlightException(Throwable cause) {
		super(cause);
	}
}

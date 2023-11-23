package com.ibsplc.his.api_his_project.exceptions;

@SuppressWarnings("serial")
public class UpdateFlightException extends Exception {

	public UpdateFlightException() {
		super();
	}
	public UpdateFlightException(String error) {
		super(error);
	}
	public UpdateFlightException(String error, Throwable cause) {
		super(error, cause);
	}
	public UpdateFlightException(Throwable cause) {
		super(cause);
	}
}

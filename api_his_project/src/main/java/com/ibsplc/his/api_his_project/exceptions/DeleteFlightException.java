package com.ibsplc.his.api_his_project.exceptions;

@SuppressWarnings("serial")
public class DeleteFlightException extends Exception {

	public DeleteFlightException() {
		super();
	}
	public DeleteFlightException(String error) {
		super(error);
	}
	public DeleteFlightException(String error, Throwable cause) {
		super(error, cause);
	}
	public DeleteFlightException(Throwable cause) {
		super(cause);
	}
}
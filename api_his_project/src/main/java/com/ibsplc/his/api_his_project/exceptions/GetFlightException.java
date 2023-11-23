package com.ibsplc.his.api_his_project.exceptions;

@SuppressWarnings("serial")
public class GetFlightException extends Exception {

	public GetFlightException() {
		super();
	}

	public GetFlightException(String error) {
		super(error);
	}
	public GetFlightException(String error, Throwable cause) {
		super(error, cause);
	}
	public GetFlightException(Throwable cause) {
		super(cause);
	}
}

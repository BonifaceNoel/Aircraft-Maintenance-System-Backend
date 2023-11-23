package com.ibsplc.his.api_his_project.exceptions;

@SuppressWarnings("serial")
public class GetFlightMaintenanceException extends Exception{

	public GetFlightMaintenanceException() {
		super();
	}
	public GetFlightMaintenanceException(String error) {
		super(error);
	}
	public GetFlightMaintenanceException(String error, Throwable cause) {
		super(error, cause);
	}
	public GetFlightMaintenanceException(Throwable cause) {
		super(cause);
	}
}

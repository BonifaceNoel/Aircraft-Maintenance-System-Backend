package com.ibsplc.his.api_his_project.exceptions;

@SuppressWarnings("serial")
public class GetMaintenanceException extends Exception{

	public GetMaintenanceException() {
		super();
	}
	public GetMaintenanceException(String error) {
		super(error);
	}
	public GetMaintenanceException(String error, Throwable cause) {
		super(error, cause);
	}
	public GetMaintenanceException(Throwable cause) {
		super(cause);
	}
}

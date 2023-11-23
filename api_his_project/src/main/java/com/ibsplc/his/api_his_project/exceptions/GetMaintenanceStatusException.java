package com.ibsplc.his.api_his_project.exceptions;

@SuppressWarnings("serial")
public class GetMaintenanceStatusException extends Exception {

	public GetMaintenanceStatusException() {
		super();
	}
	public GetMaintenanceStatusException(String error) {
		super(error);
	}
	public GetMaintenanceStatusException(String error, Throwable cause) {
		super(error, cause);
	}
	public GetMaintenanceStatusException(Throwable cause) {
		super(cause);
	}
}

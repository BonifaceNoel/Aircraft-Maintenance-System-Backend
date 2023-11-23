package com.ibsplc.his.api_his_project.exceptions;

@SuppressWarnings("serial")
public class NewMaintenanceException extends Exception{

	public NewMaintenanceException() {
		super();
	}
	public NewMaintenanceException(String error) {
		super(error);
	}
	public NewMaintenanceException(String error, Throwable cause) {
		super(error, cause);
	}
	public NewMaintenanceException(Throwable cause) {
		super(cause);
	}
}

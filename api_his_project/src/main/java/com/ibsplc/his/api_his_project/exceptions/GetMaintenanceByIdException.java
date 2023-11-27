package com.ibsplc.his.api_his_project.exceptions;

@SuppressWarnings("serial")
public class GetMaintenanceByIdException extends Exception{

	public GetMaintenanceByIdException(String error, Throwable cause) {
		super(error, cause);
	}
}

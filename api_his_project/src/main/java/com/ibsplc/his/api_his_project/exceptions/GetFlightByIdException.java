package com.ibsplc.his.api_his_project.exceptions;

@SuppressWarnings("serial")
public class GetFlightByIdException extends Exception{

	public GetFlightByIdException(String error, Throwable cause) {
		super(error, cause);
	}
}

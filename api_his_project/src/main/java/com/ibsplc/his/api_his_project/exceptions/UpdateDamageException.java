package com.ibsplc.his.api_his_project.exceptions;

@SuppressWarnings("serial")
public class UpdateDamageException extends Exception {

	public UpdateDamageException() {
		super();
	}
	public UpdateDamageException(String error) {
		super(error);
	}
	public UpdateDamageException(String error, Throwable cause) {
		super(error, cause);
	}
	public UpdateDamageException(Throwable cause) {
		super(cause);
	}
}
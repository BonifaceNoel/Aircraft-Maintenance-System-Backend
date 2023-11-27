package com.ibsplc.his.api_his_project.exceptions;

@SuppressWarnings("serial")
public class DeleteRecordException extends Exception {

	public DeleteRecordException(String error, Throwable cause) {
		super(error, cause);
	}
}
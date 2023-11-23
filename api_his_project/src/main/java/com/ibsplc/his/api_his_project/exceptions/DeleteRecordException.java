package com.ibsplc.his.api_his_project.exceptions;

@SuppressWarnings("serial")
public class DeleteRecordException extends Exception {

	public DeleteRecordException() {
		super();
	}
	public DeleteRecordException(String error) {
		super(error);
	}
	public DeleteRecordException(String error, Throwable cause) {
		super(error, cause);
	}
	public DeleteRecordException(Throwable cause) {
		super(cause);
	}
}
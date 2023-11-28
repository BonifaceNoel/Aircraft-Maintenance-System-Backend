package com.ibsplc.his.api_his_project.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class UpdateDamageException extends Exception {

	private static final Logger logger = LoggerFactory.getLogger(UpdateDamageException.class);

	public UpdateDamageException(String error, Throwable cause) {
		logger.error(error + "" + cause);
	}
}
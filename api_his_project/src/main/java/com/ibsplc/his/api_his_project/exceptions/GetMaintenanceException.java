package com.ibsplc.his.api_his_project.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class GetMaintenanceException extends Exception{

	private static final Logger logger = LoggerFactory.getLogger(GetMaintenanceException.class);

	public GetMaintenanceException(String error, Throwable cause) {
		logger.error(error + "" + cause);
	}
}

package com.ibsplc.his.api_his_project.bo;

import java.sql.Date;

public class MaintenanceRecord {

	private String maintenance_id;
	private String flight_id;
	private String maintenance_type;
	private String issue_description;
	private Date arrival_date;
	private Date completion_date;
	private String maintenance_status;
	private double maintenance_progress;

	public MaintenanceRecord() { }

	public MaintenanceRecord(String maintenance_id, String flight_id, String maintenance_type, String issue_description,
			Date arrival_date, Date completion_date, String maintenance_status, double maintenance_progress) {
		super();
		this.maintenance_id = maintenance_id;
		this.flight_id = flight_id;
		this.maintenance_type = maintenance_type;
		this.issue_description = issue_description;
		this.arrival_date = arrival_date;
		this.completion_date = completion_date;
		this.maintenance_status = maintenance_status;
		this.maintenance_progress = maintenance_progress;
	}

	public String getMaintenance_id() {
		return maintenance_id;
	}

	public void setMaintenance_id(String maintenance_id) {
		this.maintenance_id = maintenance_id;
	}

	public String getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(String flight_id) {
		this.flight_id = flight_id;
	}

	public String getMaintenance_type() {
		return maintenance_type;
	}

	public void setMaintenance_type(String maintenance_type) {
		this.maintenance_type = maintenance_type;
	}

	public String getIssue_description() {
		return issue_description;
	}

	public void setIssue_description(String issue_description) {
		this.issue_description = issue_description;
	}

	public Date getArrival_date() {
		return arrival_date;
	}

	public void setArrival_date(Date arrival_date) {
		this.arrival_date = arrival_date;
	}

	public Date getCompletion_date() {
		return completion_date;
	}

	public void setCompletion_date(Date completion_date) {
		this.completion_date = completion_date;
	}

	public String getMaintenance_status() {
		return maintenance_status;
	}

	public void setMaintenance_status(String maintenance_status) {
		this.maintenance_status = maintenance_status;
	}

	public double getMaintenance_progress() {
		return maintenance_progress;
	}

	public void setMaintenance_progress(double maintenance_progress) {
		this.maintenance_progress = maintenance_progress;
	}

	@Override
	public String toString() {
		return "MaintenanceRecord [maintenance_id=" + maintenance_id + ", flight_id=" + flight_id
				+ ", maintenance_type=" + maintenance_type + ", issue_description=" + issue_description
				+ ", arrival_date=" + arrival_date + ", completion_date=" + completion_date + ", maintenance_status="
				+ maintenance_status + ", maintenance_progress=" + maintenance_progress + "]";
	}



}

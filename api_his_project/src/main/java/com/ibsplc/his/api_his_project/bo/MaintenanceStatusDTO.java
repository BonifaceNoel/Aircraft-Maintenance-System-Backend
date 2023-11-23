package com.ibsplc.his.api_his_project.bo;

public class MaintenanceStatusDTO {

	private String aircraft_id;
	private String flight_model;
	private String flight_status;
	private String maintenance_id;
	private String maintenance_type;
	private String maintenance_status;
	private String completion_date;

	public MaintenanceStatusDTO() { }

	public MaintenanceStatusDTO(String aircraft_id, String flight_model, String flight_status, String maintenance_id,
			String maintenance_type, String maintenance_status, String completion_date) {
		super();
		this.aircraft_id = aircraft_id;
		this.flight_model = flight_model;
		this.flight_status = flight_status;
		this.maintenance_id = maintenance_id;
		this.maintenance_type = maintenance_type;
		this.maintenance_status = maintenance_status;
		this.completion_date = completion_date;
	}

	public String getAircraft_id() {
		return aircraft_id;
	}

	public void setAircraft_id(String aircraft_id) {
		this.aircraft_id = aircraft_id;
	}

	public String getFlight_model() {
		return flight_model;
	}

	public void setFlight_model(String flight_model) {
		this.flight_model = flight_model;
	}

	public String getFlight_status() {
		return flight_status;
	}

	public void setFlight_status(String flight_status) {
		this.flight_status = flight_status;
	}

	public String getMaintenance_id() {
		return maintenance_id;
	}

	public void setMaintenance_id(String maintenance_id) {
		this.maintenance_id = maintenance_id;
	}

	public String getMaintenance_type() {
		return maintenance_type;
	}

	public void setMaintenance_type(String maintenance_type) {
		this.maintenance_type = maintenance_type;
	}

	public String getMaintenance_status() {
		return maintenance_status;
	}

	public void setMaintenance_status(String maintenance_status) {
		this.maintenance_status = maintenance_status;
	}

	public String getCompletion_date() {
		return completion_date;
	}

	public void setCompletion_date(String completion_date) {
		this.completion_date = completion_date;
	}

	@Override
	public String toString() {
		return "MaintenanceStatusDTO [aircraft_id=" + aircraft_id + ", flight_model=" + flight_model
				+ ", flight_status=" + flight_status + ", maintenance_id=" + maintenance_id + ", maintenance_type="
				+ maintenance_type + ", maintenance_status=" + maintenance_status + ", completion_date="
				+ completion_date + "]";
	}

}

package com.ibsplc.his.api_his_project.bo;

public class FlightInfo {

	private String aircraft_id;
	private int reg_num;
	private String flight_model;
	private String airline;
	private String airline_id;
	private String flight_class;
	private String flight_status;

	public FlightInfo() { }

	public FlightInfo(String aircraft_id, int reg_num, String flight_model, String airline, String airline_id,
			String flight_class, String flight_status) {
		super();
		this.aircraft_id = aircraft_id;
		this.reg_num = reg_num;
		this.flight_model = flight_model;
		this.airline = airline;
		this.airline_id = airline_id;
		this.flight_class = flight_class;
		this.flight_status = flight_status;
	}

	public String getAircraft_id() {
		return aircraft_id;
	}

	public void setAircraft_id(String aircraft_id) {
		this.aircraft_id = aircraft_id;
	}

	public int getReg_num() {
		return reg_num;
	}

	public void setReg_num(int reg_num) {
		this.reg_num = reg_num;
	}

	public String getFlight_model() {
		return flight_model;
	}

	public void setFlight_model(String flight_model) {
		this.flight_model = flight_model;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getAirline_id() {
		return airline_id;
	}

	public void setAirline_id(String airline_id) {
		this.airline_id = airline_id;
	}

	public String getFlight_class() {
		return flight_class;
	}

	public void setFlight_class(String flight_class) {
		this.flight_class = flight_class;
	}

	public String getFlight_status() {
		return flight_status;
	}

	public void setFlight_status(String flight_status) {
		this.flight_status = flight_status;
	}

	@Override
	public String toString() {
		return "FlightInfo [aircraft_id=" + aircraft_id + ", reg_num=" + reg_num + ", flight_model=" + flight_model
				+ ", airline=" + airline + ", airline_id=" + airline_id + ", flight_class=" + flight_class
				+ ", flight_status=" + flight_status + "]";
	}

}

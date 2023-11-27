package com.ibsplc.his.api_his_project.service;

import java.sql.Date;
import java.util.List;

import com.ibsplc.his.api_his_project.bo.FlightInfo;
import com.ibsplc.his.api_his_project.bo.MaintenanceRecord;
import com.ibsplc.his.api_his_project.bo.MaintenanceStatusDTO;
import com.ibsplc.his.api_his_project.exceptions.GetFlightException;
import com.ibsplc.his.api_his_project.exceptions.GetMaintenanceException;

public interface MaintenanceService {

	public List<FlightInfo> getFlightDetails() throws GetFlightException;
	public List<MaintenanceRecord> getMaintenanceDetails() throws GetMaintenanceException;
	public List<MaintenanceStatusDTO> getFlightsForMaintenance();
	public List<MaintenanceStatusDTO> getMaintenanceStatus(String Status);
	public boolean newFlightDetails(String aid, int rnum, String model, String airline, String airid, String fclass, String status);
	public boolean newMaintenanceDetails(String mid, String fid, String type, String issue, Date arrive, Date complete, String mainStatus, double progress);
	public boolean updateFlight(String aid, FlightInfo flightinfo);
	public boolean updateDamage(String mid, MaintenanceRecord mainrecord);
	public boolean deleteFlight(String aid);
	public boolean deleteRecord(String mid);
	public List<FlightInfo> getFlight(String aid);
	public List<MaintenanceRecord> getRecord(String mid);
}

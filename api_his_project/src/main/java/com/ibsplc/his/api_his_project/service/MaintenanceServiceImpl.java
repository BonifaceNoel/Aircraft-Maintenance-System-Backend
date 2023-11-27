package com.ibsplc.his.api_his_project.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibsplc.his.api_his_project.bo.FlightInfo;
import com.ibsplc.his.api_his_project.bo.MaintenanceRecord;
import com.ibsplc.his.api_his_project.bo.MaintenanceStatusDTO;
import com.ibsplc.his.api_his_project.exceptions.GetFlightException;
import com.ibsplc.his.api_his_project.exceptions.GetFlightMaintenanceException;
import com.ibsplc.his.api_his_project.exceptions.GetMaintenanceException;
import com.ibsplc.his.api_his_project.exceptions.GetMaintenanceStatusException;
import com.ibsplc.his.api_his_project.exceptions.NewFlightException;
import com.ibsplc.his.api_his_project.exceptions.NewMaintenanceException;
import com.ibsplc.his.api_his_project.mapper.MaintenanceMapper;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

	@Autowired
	MaintenanceMapper mainMapper;

	@Override
	public List<FlightInfo> getFlightDetails() throws GetFlightException {

		List<FlightInfo> flights = new ArrayList<FlightInfo>();
		try {
			flights = mainMapper.getFlightsRegistered();
		}
		catch(Exception ex) {
			throw new GetFlightException("Error in get flights: ", ex.getCause());
		}

		return flights;
	}

	@Override
	public List<MaintenanceRecord> getMaintenanceDetails() throws GetMaintenanceException {

		List<MaintenanceRecord> records = new ArrayList<MaintenanceRecord>();
		try {
			records = mainMapper.getMaintenanceRegister();
		}
		catch(Exception ex) {
			throw new GetMaintenanceException("Error in get Maintenance: ", ex.getCause());
		}
		return records;
	}

	@Override
	public List<MaintenanceStatusDTO> getFlightsForMaintenance() throws GetFlightMaintenanceException {

		List<MaintenanceStatusDTO> flightdamaged = new ArrayList<MaintenanceStatusDTO>();
		try {
			flightdamaged = mainMapper.getFlightsUnderMaintenance();
		}
		catch(Exception ex) {
			throw new GetFlightMaintenanceException("Error in get Flights for maintenance: ", ex.getCause());
		}
		return flightdamaged;
	}

	@Override
	public List<MaintenanceStatusDTO> getMaintenanceStatus(String status) throws GetMaintenanceStatusException {

		List<MaintenanceStatusDTO> flightmaintained = new ArrayList<MaintenanceStatusDTO>();
		try {
			flightmaintained = mainMapper.getMaintenanceDetails(status);
		}
		catch(Exception ex) {
			throw new GetMaintenanceStatusException("Error in get Maintenance Status: ", ex.getCause());
		}
		return flightmaintained;
	}

	@Override
	public boolean newFlightDetails(String aid, int rnum, String model, String airline, String airid, String fclass,
			String status) throws NewFlightException {
		boolean result = false;
		try {
			mainMapper.newFlightDetails(aid, rnum, model, airline, airid, fclass, status);
			result = true;
		}
		catch(Exception ex) {
			result = false;
			throw new NewFlightException("Error in new Flight Details: ", ex.getCause());
		}
		return result;
	}

	@Override
	public boolean newMaintenanceDetails(String mid, String fid, String type, String issue, Date arrive, Date complete,
			String mainStatus, double progress) throws NewMaintenanceException {
		boolean result = false;
		try {
			mainMapper.newMaintenanceDetails(mid, fid, type, issue, arrive, complete, mainStatus, progress);
			result = true;
		}
		catch(Exception ex) {
			result = false;
			throw new NewMaintenanceException("Error in new Maintenance Details: ", ex.getCause());
		}
		return result;
	}

	@Override
	public boolean updateFlight(String aid, FlightInfo flightinfo) {
		try {
			mainMapper.updateFlight(flightinfo.getReg_num(), flightinfo.getFlight_model(), flightinfo.getAirline(), flightinfo.getAirline_id(), flightinfo.getFlight_class(), flightinfo.getFlight_status(), aid);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateDamage(String mid, MaintenanceRecord mainrecord) {
		try {
			mainMapper.updateDamage(mainrecord.getFlight_id(), mainrecord.getMaintenance_type(), mainrecord.getIssue_description(), mainrecord.getArrival_date(), mainrecord.getCompletion_date(), mainrecord.getMaintenance_status(), mainrecord.getMaintenance_progress(), mid);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteFlight(String aid) {
		try {
			mainMapper.deleteFlight(aid);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteRecord(String mid) {
		try {
			mainMapper.deleteRecord(mid);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<FlightInfo> getFlight(String aid) {

		List<FlightInfo> flightid = new ArrayList<FlightInfo>();
		try {
			flightid = mainMapper.getFlight().stream()
					.filter(flightInfo -> flightInfo.getAircraft_id().equals(aid))
					.collect(Collectors.toList());
			throw new GetFlightException("Error in Get Flight method");
		}
		catch(GetFlightException ex) {
			System.out.println("Caught in Get Flight method: "+ex.getMessage());
		}
		return flightid;
	}

	@Override
	public List<MaintenanceRecord> getRecord(String mid) {

		List<MaintenanceRecord> maintenanceid = new ArrayList<MaintenanceRecord>();
		try {
			maintenanceid = mainMapper.getRecord().stream()
					.filter(maintenanceRecord -> maintenanceRecord.getMaintenance_id().equals(mid))
					.collect(Collectors.toList());
			throw new GetMaintenanceException("Error in get record method");
		}
		catch(GetMaintenanceException ex) {
			System.out.println("Caught in Get Record Exception; "+ex.getMessage());
		}
		return maintenanceid;
	}
}

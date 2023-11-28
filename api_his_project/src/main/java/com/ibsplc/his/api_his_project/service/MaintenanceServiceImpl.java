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
import com.ibsplc.his.api_his_project.exceptions.DeleteFlightException;
import com.ibsplc.his.api_his_project.exceptions.DeleteRecordException;
import com.ibsplc.his.api_his_project.exceptions.GetFlightByIdException;
import com.ibsplc.his.api_his_project.exceptions.GetFlightException;
import com.ibsplc.his.api_his_project.exceptions.GetFlightMaintenanceException;
import com.ibsplc.his.api_his_project.exceptions.GetMaintenanceByIdException;
import com.ibsplc.his.api_his_project.exceptions.GetMaintenanceException;
import com.ibsplc.his.api_his_project.exceptions.GetMaintenanceStatusException;
import com.ibsplc.his.api_his_project.exceptions.NewFlightException;
import com.ibsplc.his.api_his_project.exceptions.NewMaintenanceException;
import com.ibsplc.his.api_his_project.exceptions.UpdateDamageException;
import com.ibsplc.his.api_his_project.exceptions.UpdateFlightException;
import com.ibsplc.his.api_his_project.mapper.MaintenanceMapper;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

	@Autowired
	MaintenanceMapper mainMapper;

	@Override
	public List<FlightInfo> getFlightDetails() throws GetFlightException {

		List<FlightInfo> flights = new ArrayList<>();
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

		List<MaintenanceRecord> records = new ArrayList<>();
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

		List<MaintenanceStatusDTO> flightdamaged = new ArrayList<>();
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

		List<MaintenanceStatusDTO> flightmaintained = new ArrayList<>();
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
			throw new NewMaintenanceException("Error in new Maintenance Details: ", ex.getCause());
		}
		return result;
	}

	@Override
	public boolean updateFlight(String aid, FlightInfo flightinfo) throws UpdateFlightException {
		boolean result = false;
		try {
			mainMapper.updateFlight(flightinfo.getReg_num(), flightinfo.getFlight_model(), flightinfo.getAirline(), flightinfo.getAirline_id(), flightinfo.getFlight_class(), flightinfo.getFlight_status(), aid);
			result = true;
		}
		catch(Exception ex) {
			throw new UpdateFlightException("Error in update flight: ", ex.getCause());
		}
		return result;
	}

	@Override
	public boolean updateDamage(String mid, MaintenanceRecord mainrecord) throws UpdateDamageException {
		boolean result = false;
		try {
			mainMapper.updateDamage(mainrecord.getFlight_id(), mainrecord.getMaintenance_type(), mainrecord.getIssue_description(), mainrecord.getArrival_date(), mainrecord.getCompletion_date(), mainrecord.getMaintenance_status(), mainrecord.getMaintenance_progress(), mid);
			result = true;
		}
		catch(Exception ex) {
			throw new UpdateDamageException("Error in update damage: ", ex.getCause());
		}
		return result;
	}

	@Override
	public boolean deleteFlight(String aid) throws DeleteFlightException {
		boolean result = false;
		try {
			mainMapper.deleteFlight(aid);
			result = true;
		}
		catch(Exception ex) {
			throw new DeleteFlightException("Error in delete flight: ", ex.getCause());
		}
		return result;
	}

	@Override
	public boolean deleteRecord(String mid) throws DeleteRecordException {
		boolean result = false;
		try {
			mainMapper.deleteRecord(mid);
			result = true;
		}
		catch(Exception ex) {
			throw new DeleteRecordException("Error in delete maintenance record: ", ex.getCause());
		}
		return result;
	}

	@Override
	public List<FlightInfo> getFlight(String aid) throws GetFlightByIdException {

		List<FlightInfo> flightid = new ArrayList<>();
		try {
			flightid = mainMapper.getFlight().stream()
					.filter(flightInfo -> flightInfo.getAircraft_id().equals(aid))
					.collect(Collectors.toList());
		}
		catch(Exception ex) {
			throw new GetFlightByIdException("Error in Get Flight By ID: ", ex.getCause());
		}
		return flightid;
	}

	@Override
	public List<MaintenanceRecord> getRecord(String mid) throws GetMaintenanceByIdException {

		List<MaintenanceRecord> maintenanceid = new ArrayList<>();
		try {
			maintenanceid = mainMapper.getRecord().stream()
					.filter(maintenanceRecord -> maintenanceRecord.getMaintenance_id().equals(mid))
					.collect(Collectors.toList());
		}
		catch(Exception ex) {
			throw new GetMaintenanceByIdException("Error in get maintenance by ID: ", ex.getCause());
		}
		return maintenanceid;
	}
}

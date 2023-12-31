package com.ibsplc.his.api_his_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
import com.ibsplc.his.api_his_project.service.MaintenanceService;

@RestController
@CrossOrigin(origins= "http://localhost:5173")
public class MaintenanceController {

	@Autowired
	MaintenanceService mainService;

	@GetMapping(value="/flights", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FlightInfo>> flightListAPI() throws GetFlightException {
		List<FlightInfo> flightRecord = mainService.getFlightDetails();
		ResponseEntity<List<FlightInfo>> flightEntity = null;

		if(!flightRecord.isEmpty())
			flightEntity = new ResponseEntity<>(flightRecord, HttpStatus.OK);

		else
			flightEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return flightEntity;
	}
	@GetMapping(value="/maintenance", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MaintenanceRecord>> maintenanceListAPI() throws GetMaintenanceException {
		List<MaintenanceRecord> maintenanceRecord = mainService.getMaintenanceDetails();
		ResponseEntity<List<MaintenanceRecord>> maintenanceEntity = null;

		if(!maintenanceRecord.isEmpty())
			maintenanceEntity = new ResponseEntity<>(maintenanceRecord, HttpStatus.OK);

		else
			maintenanceEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return maintenanceEntity;
	}

	@GetMapping(value="/flightdamaged", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MaintenanceStatusDTO>> maintenanceFlightAPI() throws GetFlightMaintenanceException {
		List<MaintenanceStatusDTO> mainFlights = mainService.getFlightsForMaintenance();
		ResponseEntity<List<MaintenanceStatusDTO>> mainFlightsEntity = null;

		if(!mainFlights.isEmpty())
			mainFlightsEntity = new ResponseEntity<>(mainFlights, HttpStatus.OK);

		else
			mainFlightsEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return mainFlightsEntity;
	}

	@GetMapping(value="/flightsstatus/{status}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MaintenanceStatusDTO>> maintenanceStatusAPI(@PathVariable("status") String status) throws GetMaintenanceStatusException {
		List<MaintenanceStatusDTO> mainStatus = mainService.getMaintenanceStatus(status);
		ResponseEntity<List<MaintenanceStatusDTO>> mainStatusEntity = null;

		if(!mainStatus.isEmpty())
			mainStatusEntity = new ResponseEntity<>(mainStatus, HttpStatus.OK);

		else
			mainStatusEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return mainStatusEntity;
	}

	@PostMapping(value="/newflight", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> newFlight(@RequestBody FlightInfo finfo) throws NewFlightException {
		String addStatus = "";
		ResponseEntity<String> newFlightEntity = null;

		if(mainService.newFlightDetails(finfo.getAircraft_id(), finfo.getReg_num(), finfo.getFlight_model(), finfo.getAirline(),
				finfo.getAirline_id(), finfo.getFlight_class(), finfo.getFlight_status())) {
			addStatus= "{\"Add Status\" : \"Success\"}";
			newFlightEntity = new ResponseEntity<>(addStatus, HttpStatus.OK);
		}
		else {
			addStatus= "{\"Add Status\" : \"Failure\"}";
			newFlightEntity = new ResponseEntity<>(addStatus, HttpStatus.NOT_FOUND);
		}

		return newFlightEntity;
	}

	@PostMapping(value="/newmaintenance", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> newMaintenance(@RequestBody MaintenanceRecord records) throws NewMaintenanceException {
		String addStatus = "";
		ResponseEntity<String> newMaintenanceEntity = null;

		if(mainService.newMaintenanceDetails(records.getMaintenance_id(), records.getFlight_id(), records.getMaintenance_type(), records.getIssue_description(),
				records.getArrival_date(), records.getCompletion_date(), records.getMaintenance_status(), records.getMaintenance_progress())) {
			addStatus= "{\"Add Status\" : \"Success\"}";
			newMaintenanceEntity = new ResponseEntity<>(addStatus, HttpStatus.OK);
		}
		else {
			addStatus= "{\"Add Status\" : \"Failure\"}";
			newMaintenanceEntity = new ResponseEntity<>(addStatus, HttpStatus.NOT_FOUND);
		}

		return newMaintenanceEntity;
	}

	@PutMapping(value="/updateflight/{aid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateFlight(@PathVariable("aid") String aid, @RequestBody FlightInfo flightinfo) throws UpdateFlightException {
		String updateStatus = "";
		ResponseEntity<String> newUpdateEntity = null;

		if(mainService.updateFlight(aid, flightinfo)) {
			updateStatus = "{\"Update Status\" : \"Success\"}";
			newUpdateEntity = new ResponseEntity<>(updateStatus, HttpStatus.CREATED);
		}
		else {
			updateStatus = "{\"Update Status\" : \"Failure\"}";
			newUpdateEntity = new ResponseEntity<>(updateStatus, HttpStatus.NOT_FOUND);
		}

		return newUpdateEntity;
	}

	@PutMapping(value="/updateDamage/{mid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateDamage(@PathVariable("mid") String mid, @RequestBody MaintenanceRecord mainrecord) throws UpdateDamageException {
		String updateStatus = "";
		ResponseEntity<String> newUpdateEntity = null;

		if(mainService.updateDamage(mid, mainrecord)) {
			updateStatus = "{\"Update Status\" : \"Success\"}";
			newUpdateEntity = new ResponseEntity<>(updateStatus, HttpStatus.CREATED);
		}
		else {
			updateStatus = "{\"Update Status\" : \"Failure\"}";
			newUpdateEntity = new ResponseEntity<>(updateStatus, HttpStatus.NOT_FOUND);
		}

		return newUpdateEntity;
	}

	@DeleteMapping(value="/deleteFlight/{aid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteFlight(@PathVariable("aid") String aid) throws DeleteFlightException {
		String deleteStatus = "";
		ResponseEntity<String> newDeleteEntity = null;

		if(mainService.deleteFlight(aid)) {
			deleteStatus = "{\"Delete Status\" : \"Success\"}";
			newDeleteEntity = new ResponseEntity<>(deleteStatus, HttpStatus.CREATED);
		}
		else {
			deleteStatus = "{\"Delete Status\" : \"Failure\"}";
			newDeleteEntity = new ResponseEntity<>(deleteStatus, HttpStatus.NOT_FOUND);
		}

		return newDeleteEntity;
	}

	@DeleteMapping(value="/deleteRecord/{mid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteRecord(@PathVariable("mid") String mid) throws DeleteRecordException {
		String deleteStatus = "";
		ResponseEntity<String> newDeleteEntity = null;

		if(mainService.deleteRecord(mid)) {
			deleteStatus = "{\"Delete Status\" : \"Success\"}";
			newDeleteEntity = new ResponseEntity<>(deleteStatus, HttpStatus.CREATED);
		}
		else {
			deleteStatus = "{\"Delete Status\" : \"Failure\"}";
			newDeleteEntity = new ResponseEntity<>(deleteStatus, HttpStatus.NOT_FOUND);
		}

		return newDeleteEntity;
	}

	@GetMapping(value="/flightsbyid/{aid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FlightInfo>> flightsByID(@PathVariable("aid") String aid) throws GetFlightByIdException {
		List<FlightInfo> flightProduced = mainService.getFlight(aid);
		ResponseEntity<List<FlightInfo>> flightEntity = null;

		if(!flightProduced.isEmpty())
			flightEntity = new ResponseEntity<>(flightProduced, HttpStatus.OK);

		else
			flightEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return flightEntity;
	}

	@GetMapping(value="/maintenancebyid/{mid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MaintenanceRecord>> maintenanceByID(@PathVariable("mid") String mid) throws GetMaintenanceByIdException {
		List<MaintenanceRecord> maintenanceProduced = mainService.getRecord(mid);
		ResponseEntity<List<MaintenanceRecord>> maintenanceEntity = null;

		if(!maintenanceProduced.isEmpty())
			maintenanceEntity = new ResponseEntity<>(maintenanceProduced, HttpStatus.OK);

		else
			maintenanceEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return maintenanceEntity;
	}

}

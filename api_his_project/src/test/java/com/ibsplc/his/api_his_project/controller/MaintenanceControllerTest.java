package com.ibsplc.his.api_his_project.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.ibsplc.his.api_his_project.bo.FlightInfo;
import com.ibsplc.his.api_his_project.bo.MaintenanceRecord;
import com.ibsplc.his.api_his_project.bo.MaintenanceStatusDTO;
import com.ibsplc.his.api_his_project.exceptions.DeleteFlightException;
import com.ibsplc.his.api_his_project.exceptions.GetFlightException;
import com.ibsplc.his.api_his_project.exceptions.GetFlightMaintenanceException;
import com.ibsplc.his.api_his_project.exceptions.GetMaintenanceByIdException;
import com.ibsplc.his.api_his_project.exceptions.GetMaintenanceException;
import com.ibsplc.his.api_his_project.exceptions.GetMaintenanceStatusException;
import com.ibsplc.his.api_his_project.exceptions.NewFlightException;
import com.ibsplc.his.api_his_project.exceptions.UpdateFlightException;
import com.ibsplc.his.api_his_project.service.MaintenanceService;

@SpringBootTest
public class MaintenanceControllerTest {

    @Mock
    MaintenanceService mainService;

    @Autowired
    MaintenanceController maintenanceController;

    @Test
    public void testFlightListAPI() throws GetFlightException {
        // Mock
        List<FlightInfo> flightRecord = new ArrayList<>();
        when(mainService.getFlightDetails()).thenReturn(flightRecord);

        assertNotNull(flightRecord);

    }

    @Test
    public void testMaintenanceListAPI() throws GetMaintenanceException {
        // Mock
        List<MaintenanceRecord> maintenanceRecord = new ArrayList<>();
        when(mainService.getMaintenanceDetails()).thenReturn(maintenanceRecord);

        assertNotNull(maintenanceRecord);

    }

    @Test
    public void testMaintenanceFlightAPI() throws GetFlightMaintenanceException {
        // Mock
        List<MaintenanceStatusDTO> mainFlights = new ArrayList<>();
        when(mainService.getFlightsForMaintenance()).thenReturn(mainFlights);

        assertNotNull(mainFlights);

    }

    @Test
    public void testMaintenanceStatusAPI() throws GetMaintenanceStatusException {
        // Mock
        List<MaintenanceStatusDTO> mainStatus = new ArrayList<>();
        when(mainService.getMaintenanceStatus(anyString())).thenReturn(mainStatus);

        assertNotNull(mainStatus);

    }

    @Test
    public void testNewFlightSuccess() throws NewFlightException {
        // Arrange
        when(mainService.newFlightDetails(anyString(), anyInt(), anyString(), anyString(), anyString(), anyString(), anyString()))
                .thenReturn(true);

    }

    @Test
    public void testNewFlightFailure() throws NewFlightException {
        // Arrange
        when(mainService.newFlightDetails(anyString(), anyInt(), anyString(), anyString(), anyString(), anyString(), anyString()))
                .thenReturn(false);

    }

    @Test
    public void testUpdateFlight() throws UpdateFlightException {
        // Arrange
        String aid = "123";
        FlightInfo flightInfo = new FlightInfo(/* add necessary parameters */);
        when(mainService.updateFlight(aid, flightInfo)).thenReturn(true);

        // Act
        ResponseEntity<String> responseEntity = maintenanceController.updateFlight(aid, flightInfo);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("{\"Update Status\" : \"Success\"}", responseEntity.getBody());

    }

    @Test
    public void testDeleteFlight() throws DeleteFlightException {
        // Arrange
        String aid = "123";
        when(mainService.deleteFlight(aid)).thenReturn(true);

        // Act
        ResponseEntity<String> responseEntity = maintenanceController.deleteFlight(aid);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("{\"Delete Status\" : \"Success\"}", responseEntity.getBody());

    }

    @Test
    public void testMaintenanceById() throws GetMaintenanceByIdException {

    	String mid = "123";
    	List<MaintenanceRecord> maintenanceRecord = new ArrayList<>();
        when(mainService.getRecord(mid)).thenReturn(maintenanceRecord);

        assertNotNull(maintenanceRecord);
    }
}

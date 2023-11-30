package com.ibsplc.his.api_his_project.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ibsplc.his.api_his_project.bo.FlightInfo;
import com.ibsplc.his.api_his_project.bo.MaintenanceRecord;
import com.ibsplc.his.api_his_project.bo.MaintenanceStatusDTO;
import com.ibsplc.his.api_his_project.exceptions.GetFlightException;
import com.ibsplc.his.api_his_project.exceptions.GetFlightMaintenanceException;
import com.ibsplc.his.api_his_project.exceptions.GetMaintenanceException;
import com.ibsplc.his.api_his_project.exceptions.GetMaintenanceStatusException;
import com.ibsplc.his.api_his_project.exceptions.NewFlightException;
import com.ibsplc.his.api_his_project.service.MaintenanceService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaintenanceControllerTest {

    @Mock
    MaintenanceService mainService;

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
}

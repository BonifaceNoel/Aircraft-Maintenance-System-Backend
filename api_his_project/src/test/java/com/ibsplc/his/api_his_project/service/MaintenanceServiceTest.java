package com.ibsplc.his.api_his_project.service;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ibsplc.his.api_his_project.bo.FlightInfo;
import com.ibsplc.his.api_his_project.bo.MaintenanceRecord;
import com.ibsplc.his.api_his_project.bo.MaintenanceStatusDTO;
import com.ibsplc.his.api_his_project.exceptions.GetFlightByIdException;
import com.ibsplc.his.api_his_project.exceptions.GetFlightException;
import com.ibsplc.his.api_his_project.exceptions.GetFlightMaintenanceException;
import com.ibsplc.his.api_his_project.exceptions.GetMaintenanceByIdException;
import com.ibsplc.his.api_his_project.exceptions.GetMaintenanceException;
import com.ibsplc.his.api_his_project.exceptions.GetMaintenanceStatusException;
import com.ibsplc.his.api_his_project.mapper.MaintenanceMapper;

@SpringBootTest
public class MaintenanceServiceTest {

    @Mock
    MaintenanceMapper mainMapper;

    @Test
    public void testGetFlightDetails() throws GetFlightException {
        // Mock
        List<FlightInfo> flightList = new ArrayList<>();
        when(mainMapper.getFlightsRegistered()).thenReturn(flightList);

        // Assert
        assertNotNull(flightList);
    }

    @Test
    public void testGetMaintenanceDetails() throws GetMaintenanceException {
        // Mock
        List<MaintenanceRecord> maintenanceList = new ArrayList<>();
        when(mainMapper.getMaintenanceRegister()).thenReturn(maintenanceList);

        // Assert
        assertNotNull(maintenanceList);
    }

    @Test
    public void testGetFlightsForMaintenance() throws GetFlightMaintenanceException {
        // Mock
        List<MaintenanceStatusDTO> flightDamagedList = new ArrayList<>();
        when(mainMapper.getFlightsUnderMaintenance()).thenReturn(flightDamagedList);

        // Assert
        assertNotNull(flightDamagedList);
    }

    @Test
    public void testGetMaintenanceStatus() throws GetMaintenanceStatusException {
        // Mock
        List<MaintenanceStatusDTO> maintenanceStatusList = new ArrayList<>();
        when(mainMapper.getMaintenanceDetails(anyString())).thenReturn(maintenanceStatusList);

        // Assert
        assertNotNull(maintenanceStatusList);
    }

    @Test
    public void testGetFlight() throws GetFlightByIdException {
        // Mock
        List<FlightInfo> flightList = new ArrayList<>();
        when(mainMapper.getFlight()).thenReturn(flightList);

        // Assert
        assertNotNull(flightList);
    }

    @Test
    public void testGetRecord() throws GetMaintenanceByIdException {
        // Mock
        List<MaintenanceRecord> recordList = new ArrayList<>();
        when(mainMapper.getRecord()).thenReturn(recordList);

        // Assert
        assertNotNull(recordList);
    }
}


package com.ibsplc.his.api_his_project.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ibsplc.his.api_his_project.bo.FlightInfo;
import com.ibsplc.his.api_his_project.exceptions.GetFlightException;
import com.ibsplc.his.api_his_project.service.MaintenanceService;

@ExtendWith(MockitoExtension.class)
public class MaintenanceControllerTest {

    @Mock
    private MaintenanceService mainService;

    @InjectMocks
    private MaintenanceController maintenanceController;

    @Test
    public void testFlightListAPI() throws GetFlightException {

    	//Get
        List<FlightInfo> flightRecord = new ArrayList<>();

        //Mock
        when(mainService.getFlightDetails()).thenReturn(flightRecord);

        //Act
        ResponseEntity<List<FlightInfo>> responseEntity = null;
        try {
            responseEntity = maintenanceController.flightListAPI();
        } catch (GetFlightException e) {
            fail("Exception not expected here");
        }

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(flightRecord, responseEntity.getBody());

        // Verify that mainService.getFlightDetails() was called
        verify(mainService).getFlightDetails();
    }
}

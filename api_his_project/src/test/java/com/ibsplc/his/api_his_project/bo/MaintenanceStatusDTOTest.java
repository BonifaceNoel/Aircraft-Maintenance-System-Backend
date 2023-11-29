package com.ibsplc.his.api_his_project.bo;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class MaintenanceStatusDTOTest {

    @Test
    public void testGettersAndSetters() {
        // Create a MaintenanceStatusDTO instance for testing
        MaintenanceStatusDTO maintenanceStatusDTO = new MaintenanceStatusDTO();

        // Set values using setters
        maintenanceStatusDTO.setAircraft_id("ABC123");
        maintenanceStatusDTO.setFlight_model("Boeing 747");
        maintenanceStatusDTO.setFlight_status("On Time");
        maintenanceStatusDTO.setMaintenance_id("M123");
        maintenanceStatusDTO.setMaintenance_type("Scheduled");
        maintenanceStatusDTO.setMaintenance_status("In Progress");
        maintenanceStatusDTO.setCompletion_date("2023-01-01");

        // Test getters
        assertEquals("ABC123", maintenanceStatusDTO.getAircraft_id());
        assertEquals("Boeing 747", maintenanceStatusDTO.getFlight_model());
        assertEquals("On Time", maintenanceStatusDTO.getFlight_status());
        assertEquals("M123", maintenanceStatusDTO.getMaintenance_id());
        assertEquals("Scheduled", maintenanceStatusDTO.getMaintenance_type());
        assertEquals("In Progress", maintenanceStatusDTO.getMaintenance_status());
        assertEquals("2023-01-01", maintenanceStatusDTO.getCompletion_date());
    }

    @Test
    public void testToString() {
        // Create a MaintenanceStatusDTO instance for testing
        MaintenanceStatusDTO maintenanceStatusDTO = new MaintenanceStatusDTO(
            "ABC123", "Boeing 747", "On Time",
            "M123", "Scheduled", "In Progress", "2023-01-01"
        );

        // Test the toString method
        String expectedString = "MaintenanceStatusDTO [aircraft_id=ABC123, flight_model=Boeing 747, " +
                "flight_status=On Time, maintenance_id=M123, maintenance_type=Scheduled, " +
                "maintenance_status=In Progress, completion_date=2023-01-01]";
        assertEquals(expectedString, maintenanceStatusDTO.toString());
    }
}


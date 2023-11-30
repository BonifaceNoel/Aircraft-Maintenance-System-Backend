package com.ibsplc.his.api_his_project.bo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Date;

import org.junit.jupiter.api.Test;

public class MaintenanceRecordTest {

    @Test
    public void testGettersAndSetters() {
        // Create a MaintenanceRecord instance for testing
        MaintenanceRecord maintenanceRecord = new MaintenanceRecord();

        // Set values using setters
        maintenanceRecord.setMaintenance_id("M123");
        maintenanceRecord.setFlight_id("F456");
        maintenanceRecord.setMaintenance_type("Scheduled");
        maintenanceRecord.setIssue_description("Routine check");
        maintenanceRecord.setArrival_date(new Date(0));
        maintenanceRecord.setCompletion_date(new Date(0));
        maintenanceRecord.setMaintenance_status("In Progress");
        maintenanceRecord.setMaintenance_progress(50.0);

        // Test getters
        assertEquals("M123", maintenanceRecord.getMaintenance_id());
        assertEquals("F456", maintenanceRecord.getFlight_id());
        assertEquals("Scheduled", maintenanceRecord.getMaintenance_type());
        assertEquals("Routine check", maintenanceRecord.getIssue_description());
        assertNotNull(maintenanceRecord.getArrival_date());
        assertNotNull(maintenanceRecord.getCompletion_date());
        assertEquals("In Progress", maintenanceRecord.getMaintenance_status());
        assertEquals(50.0, maintenanceRecord.getMaintenance_progress(), 0.01); // Allow a small delta for double comparison
    }

    @Test
    public void testToString() {
        // Create a MaintenanceRecord instance for testing
        MaintenanceRecord maintenanceRecord = new MaintenanceRecord(
            "M123", "F456", "Scheduled", "Routine check",
            new Date(0), new Date(0), "In Progress", 50.0
        );

        // Test the toString method
        String expectedString = "MaintenanceRecord [maintenance_id=M123, flight_id=F456, maintenance_type=Scheduled, " +
                "issue_description=Routine check, arrival_date=" + maintenanceRecord.getArrival_date() +
                ", completion_date=" + maintenanceRecord.getCompletion_date() +
                ", maintenance_status=In Progress, maintenance_progress=50.0]";
        assertEquals(expectedString, maintenanceRecord.toString());
    }
   @Test
   public void dataMock() {
	   MaintenanceRecord mainRecord = mock(MaintenanceRecord.class);

	   when(mainRecord.getFlight_id()).thenReturn("F456");
	   when(mainRecord.getMaintenance_id()).thenReturn("M123");
   }
}

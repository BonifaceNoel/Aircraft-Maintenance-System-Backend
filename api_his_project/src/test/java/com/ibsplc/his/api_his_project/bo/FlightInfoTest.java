package com.ibsplc.his.api_his_project.bo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class FlightInfoTest {

	public FlightInfo flightInfo;

    @Before
    public void setUp() {
        // Initialize a FlightInfo object before each test
        flightInfo = new FlightInfo("ABC123", 123456, "Boeing 747", "Example Airlines", "E123", "Business", "On Time");
    }

    @Test
    public void testGetterAndSetter() {
        // Test getter and setter methods for each property
        assertEquals("ABC123", flightInfo.getAircraft_id());
        assertEquals(123456, flightInfo.getReg_num());
        assertEquals("Boeing 747", flightInfo.getFlight_model());
        assertEquals("Example Airlines", flightInfo.getAirline());
        assertEquals("E123", flightInfo.getAirline_id());
        assertEquals("Business", flightInfo.getFlight_class());
        assertEquals("On Time", flightInfo.getFlight_status());

        // Modify some properties using setters
        flightInfo.setAircraft_id("XYZ789");
        flightInfo.setReg_num(987654);
        flightInfo.setFlight_model("Airbus A380");

        // Check if modifications are reflected
        assertEquals("XYZ789", flightInfo.getAircraft_id());
        assertEquals(987654, flightInfo.getReg_num());
        assertEquals("Airbus A380", flightInfo.getFlight_model());
    }

    @Test
    public void testToString() {
        // Test the toString method
        String expectedString = "FlightInfo [aircraft_id=ABC123, reg_num=123456, flight_model=Boeing 747, " +
                "airline=Example Airlines, airline_id=E123, flight_class=Business, flight_status=On Time]";
        assertEquals(expectedString, flightInfo.toString());
    }

    @Test
    public void dataMock() {
    	FlightInfo flightInfo = mock(FlightInfo.class);

    	when(flightInfo.getAircraft_id()).thenReturn("ABC123");
    	when(flightInfo.getAirline_id()).thenReturn("Example Airlines");
    }
}

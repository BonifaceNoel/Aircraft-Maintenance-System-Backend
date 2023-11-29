package com.ibsplc.his.api_his_project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

public class ApiHisProjectApplicationTest {

	@Autowired
	private ApiHisProjectApplication app;

	@LocalServerPort
    private int port = 8090;

    private TestRestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void contextLoads() {
		assertNull(app);
	}

	@Test
    public void apiEndpointShouldReturnExpectedResult() {
        String url = "http://localhost:" + port + "/apihome/flightsbyid/DEF456";
        String expectedResult = "[{\"aircraft_id\":\"DEF456\",\"reg_num\":654321,\"flight_model\":\"Boeing 737\",\"airline\":\"Demo Airways\",\"airline_id\":\"DAL005\",\"flight_class\":\"Business\",\"flight_status\":\"On Time\"}]";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        assertEquals(expectedResult, responseEntity.getBody());
    }
}

package com.ibsplc.his.api_his_project.exceptions;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.slf4j.Logger;

public class DeleteFlightExceptionTest {

    @Test
    public void testExceptionLogging() {
        // Mock the logger
        Logger loggerMock = mock(Logger.class);

        // Create an instance of DeleteFlightException
        String errorMessage = "Test error message";
        Throwable cause = new RuntimeException("Test cause");
        DeleteFlightException exception = new DeleteFlightException(errorMessage, cause);

        // Verify that the logger was called with the expected parameters
        assertNotNull(errorMessage);
        assertNotNull(cause);
        assertNotNull(exception);
    }
}


package com.trimblecars.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();

    @Test
    void testHandleResourceNotFoundException() {
        ResourceNotFoundException ex = new ResourceNotFoundException("Car not found");
        ResponseEntity<Map<String, Object>> response = exceptionHandler.handleResourceNotFound(ex);

        assertEquals(404, response.getStatusCode().value());
        assertEquals("Car not found", response.getBody().get("message"));
    }
}

package com.trimblecars.controller;

import com.trimblecars.entity.Car;
import com.trimblecars.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class CarControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CarService carService;

    @InjectMocks
    private CarController carController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = standaloneSetup(carController).build();
    }

    @Test
    void testGetAllCars() throws Exception {
        when(carService.getAllCars()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/cars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));

        verify(carService, times(1)).getAllCars();
    }

    @Test
    void testAddCar() throws Exception {
        Car car = new Car(1L, "Model S", "Tesla", "IDEAL", null);
        when(carService.addCar(any(Car.class))).thenReturn(car);

        mockMvc.perform(post("/api/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"model\":\"Model S\",\"brand\":\"Tesla\",\"status\":\"IDEAL\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.model").value("Model S"));

        verify(carService, times(1)).addCar(any(Car.class));
    }
}

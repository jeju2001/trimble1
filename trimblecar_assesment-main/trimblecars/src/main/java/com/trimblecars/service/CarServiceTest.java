package com.trimblecars.service;

import com.trimblecars.entity.Car;
import com.trimblecars.exception.ResourceNotFoundException;
import com.trimblecars.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCarById_CarExists() {
        Car car = new Car(1L, "Model S", "Tesla", "IDEAL", null);
        when(carRepository.findById(1L)).thenReturn(Optional.of(car));

        Car result = carService.getCarById(1L);

        assertNotNull(result);
        assertEquals("Model S", result.getModel());
        verify(carRepository, times(1)).findById(1L);
    }

    @Test
    void testGetCarById_CarNotFound() {
        when(carRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> carService.getCarById(1L));
    }
}

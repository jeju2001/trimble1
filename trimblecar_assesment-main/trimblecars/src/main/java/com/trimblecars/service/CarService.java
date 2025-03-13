package com.trimblecars.service;

import com.trimblecars.entity.Car;
import com.trimblecars.exception.ResourceNotFoundException;
import com.trimblecars.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car with ID " + id + " not found"));
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }
}

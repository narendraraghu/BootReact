package com.narendra.java.controllers;

import com.narendra.java.pojo.Car;
import com.narendra.java.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @RequestMapping(value = "/car", method = RequestMethod.GET)
    public Iterable<Car> getAll() {
        return carRepository.findAll();
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "Hello Horeku";
    }
}

package com.sda.carrent.controller;

import com.sda.carrent.dto.CarDTO;
import com.sda.carrent.dto.Response;
import com.sda.carrent.dto.ResponseMapper;
import com.sda.carrent.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/rest/car.svc")
@CrossOrigin
public class CarController {

    private final CarService carService;
    private final ResponseMapper responseMapper;

    @Autowired
    public CarController(CarService carService, ResponseMapper responseMapper) {
        this.carService = carService;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/car")
    public Response createCar(@Valid @RequestBody CarDTO carDTO) {
//        if (carService.doesModelExist(carDTO.getModel())) {
//            return responseMapper.mapFail("Car model: " + carDTO.getModel() + " already exists", "WARNING");
//        }
        return responseMapper
                .mapSuccess(carService.createCar(carDTO));
    }

    @GetMapping("/cars")
    public Response getAllCars() {
        return responseMapper
                .mapSuccess(carService.getCars());
    }

    @GetMapping("/car({id})")
    public Response getCarById(@PathVariable("id") Long id) {
        return responseMapper
                .mapSuccess(carService.getCarById(id));
    }

    @PutMapping("/car")
    public Response updateCar(@RequestBody CarDTO carDTO) {
        return responseMapper
                .mapSuccess(carService.updateCar(carDTO));
    }

    @PostMapping("/cars/search")
    public Response search(@RequestBody CarDTO carDTO) {
        return responseMapper
                .mapSuccess(carService.search(carDTO));
    }

    @DeleteMapping("/car({id})")
    public Response deleteCar(@PathVariable("id") Long id) {
        return responseMapper
                .mapSuccess(carService.deleteCar(id));
    }

}

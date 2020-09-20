package com.sda.carrent.service;

import com.sda.carrent.dto.CarDTO;
import com.sda.carrent.mapper.CarMapper;
import com.sda.carrent.model.Car;
import com.sda.carrent.model.Customer;
import com.sda.carrent.model.userTypeEnum.CarStatus;
import com.sda.carrent.repository.CarRepository;
import org.hibernate.validator.cfg.defs.CreditCardNumberDef;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Autowired
    public CarService(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public CarDTO createCar(CarDTO carDTO) {
        Car car = carMapper.fromDTO(carDTO);
        Car cratedCar = carRepository.save(car);
        return carMapper.toDTO(cratedCar);
    }

    public CarDTO updateCar(CarDTO carDTO) {
        Car carToUpdate = carMapper.fromDTO(carDTO);
        Car carFromDB = carRepository.getOne(carDTO.getCarPk());
        BeanUtils.copyProperties(carToUpdate, carFromDB, "carPk");
        carRepository.save(carFromDB);
        return carMapper.toDTO(carFromDB);
    }

    public List<CarDTO> getCars() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(carMapper::toDTO)
                .filter(t -> "ACTIVE".equals(t.getStatusInDb()))
                .collect(Collectors.toList());
    }

    public CarDTO getCarById(Long id) {
        Optional<Car> optionalCar= carRepository.findById(id);
        Car car = optionalCar.orElseGet(Car::new);
        return carMapper.toDTO(car);
    }

    public List<CarDTO> search(CarDTO carDTO) {
        Car car = carMapper.fromDTO(carDTO);
        Example<Car> carExample = Example.of(car);
        List<Car> cars = carRepository.findAll(carExample);
        return cars.stream()
                .map(carMapper::toDTO)
                .filter(t -> "ACTIVE".equals(t.getStatusInDb()))
                .collect(Collectors.toList());
    }

    public CarDTO deleteCar(Long id) {
        Car car = carRepository.getOne(id);
        car.setStatusInDb("DELETED");
        carMapper.toDTO(car);
        Car deletedCar = carRepository.save(car);
        return carMapper.toDTO(deletedCar);

    }

    public CarDTO setCarBookingStatusToRented(Long id) {
        Car car = carRepository.getOne(id);
        car.setCarStatus(CarStatus.RENTED);
        return carMapper.toDTO(car);
    }

    public Boolean isCarBooked(Long id) {
        Car car = carRepository.getOne(id);
        if (car.getCarStatus().equals(CarStatus.RENTED)) {
            return true;
        }
        return false;
    }



}

package com.sda.carrent.service;

import com.sda.carrent.dto.CarDTO;
import com.sda.carrent.mapper.CarMapper;
import com.sda.carrent.model.Car;
import com.sda.carrent.model.userTypeEnum.CarStatus;
import com.sda.carrent.repository.CarRepository;
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

    public void updateCar(CarDTO carDTO) {
        Car carToUpdate = carMapper.fromDTO(carDTO);
        Car carFromDB = carRepository.getOne(carDTO.getCarPk());
        BeanUtils.copyProperties(carToUpdate, carFromDB, "carPk");
        carRepository.save(carFromDB);
    }

    public List<CarDTO> getCars() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(carMapper::toDTO)
//                .filter(t -> "ACTIVE".equals(t.getStatus()))
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
                .collect(Collectors.toList());
    }

    public CarDTO deleteCar(Long id) {
        Car car = carRepository.getOne(id);
        car.setStatusInDb("DELETED");
        carMapper.toDTO(car);
        Car deletedCar = carRepository.save(car);
        return carMapper.toDTO(deletedCar);

    }

    public Boolean doesModelExist(String model) {
        Car car = carRepository.findByModel(model);
        return car != null;
    }


}

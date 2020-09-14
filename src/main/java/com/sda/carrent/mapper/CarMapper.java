package com.sda.carrent.mapper;

import com.sda.carrent.dto.CarDTO;
import com.sda.carrent.model.Car;
import com.sda.carrent.model.userTypeEnum.CarBodyType;
import com.sda.carrent.model.userTypeEnum.CarStatus;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public Car fromDTO(CarDTO carDTO) {
        Car car = new Car();

        car.setCarPk(carDTO.getCarPk());
        car.setMake(carDTO.getMake());
        car.setModel(carDTO.getModel());
        if (carDTO.getCarBodyType() == null) {
            car.setCarBodyType(null);
        } else {
            car.setCarBodyType(CarBodyType.valueOf(carDTO.getCarBodyType()));
        }
        car.setYearOfProduction(carDTO.getYearOfProduction());
        car.setMileage(carDTO.getMileage());
        if (carDTO.getStatus() == null) {
            car.setCarStatus(null);
        } else {
            car.setCarStatus(CarStatus.valueOf(carDTO.getStatus()));
        }
        car.setAmount(carDTO.getAmount());
        car.setStatusInDb(carDTO.getStatusInDb());

        return car;
    }


    public CarDTO toDTO(Car car) {
        CarDTO carDTO = new CarDTO();

        carDTO.setCarPk(car.getCarPk());
        carDTO.setMake(car.getMake());
        carDTO.setModel(car.getModel());
        carDTO.setCarBodyType(car.getCarBodyType().name());
        carDTO.setYearOfProduction(car.getYearOfProduction());
        carDTO.setMileage(car.getMileage());
        carDTO.setStatus(car.getCarStatus().name());
        carDTO.setAmount(car.getAmount());
        carDTO.setStatusInDb(car.getStatusInDb());

        return carDTO;
    }


}

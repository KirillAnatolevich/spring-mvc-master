package web.service;


import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.Car;
import web.repository.CarRepository;

import javax.xml.ws.soap.Addressing;
import java.util.List;
import java.util.Random;

@Service
@Data
@Getter
public class CarService {
    @Autowired
    CarRepository carRepository;

    public List<Car> createListCars(){
        carRepository.createListCar(carRepository.getQuantity());
        return carRepository.getCars();
    }

    public CarService (){}
}
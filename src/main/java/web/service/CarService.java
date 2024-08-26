package web.service;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.Car;
import web.repository.CarRepository;

import javax.xml.ws.soap.Addressing;
import java.util.List;
import java.util.Random;

@Service
@Data
public class CarService {
    @Autowired
    CarRepository carRepository;

    public List<Car> createListCar(int quantity){
        carRepository = new CarRepository();
        carRepository.createListCar(quantity);
        return carRepository.getCars();
    }


    public CarService (){}
}

package web.repository;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Data
public class CarRepository {
    private List<Car> cars = new ArrayList<>();
    private final String[] model = {"Gaz","Ford","micubisi","Lombsrgini","Ural"};
    private final String[] color = {"Black","Silver","Red","Yellow","Green"};
    private final int[] sped = {100,50,150,200,250};
    private final int quantity = 5;

    public CarRepository() {}

    public List<Car> createListCar(int quantity){
        for (int i = 0; i < quantity; i++){
            cars.add(new Car(model[new Random().nextInt(quantity)], color[new Random().nextInt(quantity)], sped[new Random().nextInt(quantity)]));
        }
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}

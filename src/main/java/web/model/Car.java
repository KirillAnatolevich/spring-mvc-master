package web.model;


import lombok.Data;

@Data
public class Car {
    private String model;
    private String color;
    private int sped;

    public Car() {
    }

    public Car(String model, String color, int sped) {
        this.model = model;
        this.color = color;
        this.sped = sped;
    }
}

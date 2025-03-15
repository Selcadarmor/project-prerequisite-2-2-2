package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private List<Car> cars;
    public CarService() {
        cars = new ArrayList<>();
        cars.add(new Car("Model S", "Tesla", 2022));
        cars.add(new Car("Mustang", "Ford", 2025));
        cars.add(new Car("Civic", "Honda", 2013));
        cars.add(new Car("Accord", "Honda", 2021));
        cars.add(new Car("Camry", "Toyota", 2020));
    }
    public List<Car> getCars(int count) {
        if (count >= 5) {
            return cars;
        }
        return cars.subList(0, Math.min(count, cars.size()));
    }
}

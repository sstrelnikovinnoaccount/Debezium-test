package com.example.debeziumtest.cars;

import com.example.debeziumtest.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(final CarRepository carRepository)
    {
        this.carRepository = carRepository;
    }

    public List<Car> loadAll()
    {
        return carRepository.findAll();
    }

    public Car loadById(final long id)
    {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("No car found with %d id", id)));
    }

    public Car createCar(final Car car)
    {
        if (Objects.nonNull(car.getId()))
            throw new RuntimeException("Can't create car, id is defined");
        return carRepository.save(car);
    }

    public Car editCar(final Car car, final long id)
    {
        car.setId(id);
        return carRepository.save(car);
    }

    public void deleteCar(final long id)
    {
        carRepository.deleteById(id);
    }
}
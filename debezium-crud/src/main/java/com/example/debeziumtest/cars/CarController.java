package com.example.debeziumtest.cars;

import com.example.debeziumtest.users.User;
import com.example.debeziumtest.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/car")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(final CarService carService)
    {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> loadAll()
    {
        return carService.loadAll();
    }

    @GetMapping(path = "/{id}")
    public Car loadById(final @PathVariable("id") long id)
    {
        return carService.loadById(id);
    }

    @PostMapping
    public Car createCar(final @RequestBody Car car)
    {
        return carService.createCar(car);
    }

    @PutMapping(path = "/{id}")
    public Car editCar(final @RequestBody Car car, final @PathVariable("id") long id)
    {
        return carService.editCar(car, id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCar(final @PathVariable("id") long id)
    {
        carService.deleteCar(id);
    }
}
package com.example.buycarsmanagerapi.web;


import com.example.buycarsmanagerapi.modele.Car;
import com.example.buycarsmanagerapi.modele.Person;
import com.example.buycarsmanagerapi.services.CarServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cars")
@CrossOrigin
public class CarController {

    private CarServices carServices;

    public CarController(CarServices carServices) {
        this.carServices = carServices;
    }

    //endpoint pentru afisare masini

    @GetMapping("/allCars")
    public ResponseEntity <List<Car>> getAllCars(){
        List<Car> cars=carServices.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.ACCEPTED);
    }

    //endpoint pt update masina
    @PutMapping("/updateCars")
    public ResponseEntity<Car> UpdateCar(@RequestBody Car car){
        this.carServices.updateCars(car);

        return new ResponseEntity<>(car, HttpStatus.ACCEPTED);
    }

    //endpoint stergere masina

    @DeleteMapping("/deleteCar/{id}")
    public ResponseEntity<Car> deleteC(@PathVariable Long id){
        this.carServices.deleteCar(id);
        return null;
    }



}

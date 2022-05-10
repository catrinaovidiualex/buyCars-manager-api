package com.example.buycarsmanagerapi.services;

import com.example.buycarsmanagerapi.exceptions.BadRequest;
import com.example.buycarsmanagerapi.exceptions.CarNotFound;
import com.example.buycarsmanagerapi.exceptions.PersonNotFound;
import com.example.buycarsmanagerapi.modele.Car;
import com.example.buycarsmanagerapi.modele.Person;
import com.example.buycarsmanagerapi.repository.CarRepository;
import com.example.buycarsmanagerapi.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServices {

    private CarRepository carRepository;


    public CarServices(CarRepository carRepository) {

        this.carRepository = carRepository;
    }

    //getAllCars
    public List<Car> getAllCars() {
        return this.carRepository.findAll();
    }


    //updateCars
    public Car updateCars(Car cars) {
        Car oldCars = null;
        Optional<Car> optCars = carRepository.findById(cars.getId());
        if (optCars.isPresent()) {
            oldCars = optCars.get();
            oldCars.setAn(cars.getAn());
            oldCars.setCombustibil(cars.getCombustibil());
            oldCars.setMarca(cars.getMarca());
            oldCars.setPret(cars.getPret());


            carRepository.save(oldCars);
        }else{
            throw new CarNotFound("Car not found!");
        }

        return oldCars;
    }

    public void deleteCar(Long id){
        Optional<Car> car=carRepository.findById(id);
        if(car.isPresent()){
            carRepository.deleteById(id);
        }else{
            throw new CarNotFound("Car does not exist");
        }
    }





}







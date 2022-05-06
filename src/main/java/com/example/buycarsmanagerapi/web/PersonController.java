package com.example.buycarsmanagerapi.web;

import com.example.buycarsmanagerapi.modele.Car;
import com.example.buycarsmanagerapi.modele.Person;
import com.example.buycarsmanagerapi.repository.PersonRepository;
import com.example.buycarsmanagerapi.services.PersonServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/persons")
@CrossOrigin
public class PersonController {

    private PersonServices personServices;

    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

    //endpoint pentru afisarea tuturor persoanelor

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAll() {
        List<Person> persoane = personServices.getAll();
        return new ResponseEntity(persoane, HttpStatus.ACCEPTED);
    }

    //endpoint pentru adaugare persoana
    @PostMapping("/add")
    public ResponseEntity<Person> addPerson(@RequestBody Person pers) {
        this.personServices.addPerson(pers);
        return new ResponseEntity<Person>(pers, HttpStatus.ACCEPTED);
    }

    //endpoint pentru stergere persoana dupa id
    @DeleteMapping("/deletePers/{id}")
    public ResponseEntity<Person> deletePers(@PathVariable Long id) {
        this.personServices.deletePs(id);
        return null;
    }

    //endpoint pentru update persoana
    @PutMapping("/update")
    public ResponseEntity<Person> UpdatePers(@RequestBody Person person) {
        this.personServices.updatePers(person);


        return new ResponseEntity<>(person, HttpStatus.ACCEPTED);


    }


    //endpoint pentru afisare masini in functie de id persoana

    @GetMapping("/getCarsByIDPers/{id}")
    public ResponseEntity<List<Car>> getCarsByIDPers(@PathVariable Long id) {
        List<Car> carsByPers = personServices.getPersonCars(id);
        return new ResponseEntity<>(carsByPers, HttpStatus.ACCEPTED);
    }

    @PostMapping("/addCarsByIDPers/{id}")
    public ResponseEntity<Car> addCarsByIDPers(@PathVariable Long id, @RequestBody Car car) {
        personServices.addNewCar(id, car);
        return new ResponseEntity<>(car, HttpStatus.ACCEPTED);

    }

}












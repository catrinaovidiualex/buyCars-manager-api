package com.example.buycarsmanagerapi;

import com.example.buycarsmanagerapi.modele.Car;
import com.example.buycarsmanagerapi.modele.Person;
import com.example.buycarsmanagerapi.repository.CarRepository;
import com.example.buycarsmanagerapi.repository.PersonRepository;
import com.example.buycarsmanagerapi.services.PersonServices;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BuyCarsManagerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuyCarsManagerApiApplication.class, args);

    }
    //adaugare masini noua pt o anumita persoana cu id specificat
    /*@Bean
    CommandLineRunner commandLineRunnerAddNewCar(PersonServices personServices){
        return args ->{

            Car c4= new Car("BMW Seria 3","benzina",2002,8999);

            // adagam masina c4 la persoana cu id 4

            personServices.addNewCar(1L,c4);

        };

    }*/

    }






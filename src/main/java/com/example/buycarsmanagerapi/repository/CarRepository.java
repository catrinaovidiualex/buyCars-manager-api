package com.example.buycarsmanagerapi.repository;

import com.example.buycarsmanagerapi.modele.Car;
import com.example.buycarsmanagerapi.modele.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    //filtrare masina dupa id

    @Query(value = "select c from Car c where  c.id=:id")
    Optional<Car>findCarById(Long id);
}

package com.example.buycarsmanagerapi.repository;

import com.example.buycarsmanagerapi.modele.Car;
import com.example.buycarsmanagerapi.modele.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Period;
import java.util.Optional;

@Repository

public interface PersonRepository extends JpaRepository<Person,Long> {

    //filtrare persoane dupa nume

    @Query(value = "select p from Person p where  p.nume =:name")
    Optional<Person>findPersonByName(String name);






}

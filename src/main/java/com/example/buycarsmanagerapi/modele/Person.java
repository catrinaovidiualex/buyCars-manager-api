package com.example.buycarsmanagerapi.modele;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name="Person")
@Table(name="persons")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {


    @Id
    @SequenceGenerator(
            name="person_sequence",
            sequenceName = "persons_sequence",
            allocationSize =100
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )

    @Column(name="id")
    Long id;

    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation/2.6.6  de aici sepoate copia dependenta pt a folosi @NotBlank
    @Column(name="nume")
    @NotBlank(message="valoarea numelui trebuie introdusa obligatoriu")
    private String nume;

    @Column(name="tipUser")
    @NotBlank(message="valoarea tipului de user trebuie introdusa obligatoriu")
    private String tipUser;

    @Column(name="user")
    @NotBlank(message="valoarea userului trebuie introdusa obligatoriu")
    private String user;

    @Column(name="parola")
    @NotBlank(message="valoarea parolei trebuie introdusa obligatoriu")
    private String parola;
    @OneToMany(
            mappedBy = "person", // person declarad in clasa Car (linia 78)
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER


    )
    @JsonManagedReference
    List<Car> cars= new ArrayList<>();


    public Person(String nume, String tipUser, String user, String parola) {
        this.nume = nume;
        this.tipUser = tipUser;
        this.user = user;
        this.parola = parola;
    }

    public void addCar(Car car){
        this.cars.add(car);
        car.setPerson(this);
    }




}

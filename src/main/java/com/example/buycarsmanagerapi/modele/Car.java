package com.example.buycarsmanagerapi.modele;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotBlank.List;

@Data
@Entity(name = "Car")
@Table(name = "cars")

@AllArgsConstructor
@NoArgsConstructor

public class Car {


    @Id
    @SequenceGenerator(
            name = "car_sequence",
            sequenceName = "cars_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "car_sequence"
    )
            @Column(
                    name="id"
            )

    Long id;

    // @Column creaza tabela marca in SQL intrucat o avem ca si obiect in spring
    @Column(name="marca")
    @NotBlank(message="valoarea marcii trebuie introdusa obligatoriu")
    private String marca;


    @Column(name="combustibil")
    @NotBlank(message="valoarea combustibilului trebuie introdusa obligatoriu")
    private String combustibil;

    @Column(name="an")
    private int an;

    @Column(name="pret")
    private int pret;

    // folosim stop in momentul in care se cumpara masina


    public Car(String marca, String combustibil, int an, int pret) {
        this.marca = marca;
        this.combustibil = combustibil;
        this.an = an;
        this.pret = pret;
    }


    @ManyToOne
    @JoinColumn(
            name="person_id",
            referencedColumnName = "id",// din tabela person
            foreignKey = @ForeignKey(

                    name="person_id_fk"
            )

    )
    @JsonBackReference
    Person person;




}

package com.example.buycarsmanagerapi.services;

import com.example.buycarsmanagerapi.exceptions.BadRequest;
import com.example.buycarsmanagerapi.exceptions.DetailsNotFound;
import com.example.buycarsmanagerapi.exceptions.PersonNotFound;
import com.example.buycarsmanagerapi.modele.Car;
import com.example.buycarsmanagerapi.modele.Person;
import com.example.buycarsmanagerapi.repository.CarRepository;
import com.example.buycarsmanagerapi.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonServices {



    private PersonRepository personRepository;


    public PersonServices(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //getAllPersons
    public List<Person> getAll(){
        return  this.personRepository.findAll();
    }

    // adaugare persoana, mai intain verificam daca exista pentru a evita duplicarea si apoi o adaugam
    public  void addPerson(Person person){

        Optional<Person> existName= personRepository
                .findPersonByName(person.getNume());

        if(existName.isPresent()==false){
            personRepository.save(new Person(person.getNume(),person.getParola(),person.getTipUser(),person.getUser()));
        }else{
            throw new BadRequest("Nume"+person.getNume()+"is taken");
        }



    }

    // stergere persoana existenta
    public void deletePs(Long id){
        Optional<Person> person=personRepository.findById(id);
        if(person.isPresent()){
            personRepository.deleteById(id);
        }else{
            throw new BadRequest("Person does not exist");
        }

    }

    public Person updatePers(Person pers){
        Person oldPers=null;
        Optional<Person> optionalPers=personRepository.findPersonByName(pers.getNume());
        if(optionalPers.isPresent()) {
            oldPers=optionalPers.get();
            oldPers.setNume(pers.getNume());
            oldPers.setParola(pers.getParola());
            oldPers.setTipUser(pers.getTipUser());
            oldPers.setUser(pers.getUser());

            personRepository.save(oldPers);
        }else{
            throw  new PersonNotFound("Person not found!");
        }
        return oldPers;
    }

    public boolean findPersByID(Long id){
        Person existPers=null;
        Optional<Person> optionalPs=personRepository.findById(id);
        if(optionalPs.isPresent()){
            existPers=optionalPs.get();
            personRepository.deleteById(id);

        }else{
            throw new DetailsNotFound("Please double check inserted details");
        }
        return false;
    }

    //adaugare masina noua la o persoana cu id-ul specificat
    public void addNewCar(long idPerson,Car newC){


       //cautam persoana
      Optional<Person> existName= personRepository.findById(idPerson);
      if(existName.isPresent()==true){
            boolean contains = existName.get().getCars().contains(newC);
           if(contains==false){
                //verificam daca persoana are deja masina;
               existName.get().addCar(newC);
                //adaugam masina la persoana
                personRepository.save(existName.get());
            }

        }else{
            throw new DetailsNotFound(findPersByID(idPerson)+"not exist");
        }





    }

    // returneaza toate masinile unei persoane

    public  List<Car> getPersonCars(Long idPerson){
        Optional<Person> opPers=personRepository.findById(idPerson);
        if(opPers.isPresent()){
            return opPers.get().getCars();
        }else{
            throw  new PersonNotFound("Person not found!");
        }

    }






}






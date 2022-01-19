package com.example.springbootelasticsearch.controller;

import com.example.springbootelasticsearch.model.Person;
import com.example.springbootelasticsearch.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository personRepository;

    @PostConstruct
    public void init(){
        Person person = new Person();
        person.setName("Elif");
        person.setLastName("Yılancı");
        person.setAddress("Trabzon");
        person.setId("K0001");
        personRepository.save(person);

        Person person1 = new Person();
        person1.setName("Rana");
        person1.setLastName("Yılancı");
        person1.setAddress("Trabzon");
        person1.setId("K0002");
        personRepository.save(person1);

    }

//    @GetMapping("/{search}")
//    public ResponseEntity<List<Person>> getPerson(@PathVariable String search){
//
//        List<Person> persons = personRepository.getByCustomQuery(search);
//        return ResponseEntity.ok(persons);
//
//    }

    @GetMapping("/contains/{search}")
    public ResponseEntity<List<Person>> getContainsPerson(@PathVariable String search){

        List<Person> persons = personRepository.findByNameContaining(search);
        return ResponseEntity.ok(persons);

    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Person>> getLikePerson(@PathVariable String search){

        List<Person> persons = personRepository.findByNameLikeOrLastName(search,search);
        return ResponseEntity.ok(persons);

    }
}

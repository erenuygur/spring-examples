package com.erenuygur.elasticsearch.contoller;

import com.erenuygur.elasticsearch.entity.Person;
import com.erenuygur.elasticsearch.repository.PersonRepository;
import jakarta.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostConstruct
    public void init(){
        Person person =new Person();
        person.setName("Eren");
        person.setSurname("Uygur");
        person.setAddress("TR");
        person.setBirthDate(LocalDate.of(1999, Month.SEPTEMBER, 9));
        person.setId("EU99");
        personRepository.save(person);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Person>> getPerson(@PathVariable String search) {
        List<Person> personList = personRepository.getByCustomQuery(search);
        return ResponseEntity.ok(personList);
    }
}

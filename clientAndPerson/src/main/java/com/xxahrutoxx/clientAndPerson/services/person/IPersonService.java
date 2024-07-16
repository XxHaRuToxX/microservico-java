package com.xxahrutoxx.clientAndPerson.services.person;


import com.xxahrutoxx.clientAndPerson.entities.Person;

import java.util.List;

public interface IPersonService {
    List<Person> findAll();
    Person findById(Long id);
    void save(Person person);
}

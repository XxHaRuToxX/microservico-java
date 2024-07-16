package com.xxahrutoxx.clientAndPerson.services.person;

import com.xxahrutoxx.clientAndPerson.entities.Person;
import com.xxahrutoxx.clientAndPerson.persistences.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonRepository iPersonRepository;

    @Override
    public List<Person> findAll() {
        return (List<Person>) iPersonRepository.findAll();
    }

    @Override
    public Person findById(Long id) {
        return iPersonRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Person person) {
        iPersonRepository.save(person);
    }
}

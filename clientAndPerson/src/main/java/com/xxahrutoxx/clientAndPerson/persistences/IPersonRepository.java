package com.xxahrutoxx.clientAndPerson.persistences;

import com.xxahrutoxx.clientAndPerson.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends CrudRepository<Person, Long> {
}

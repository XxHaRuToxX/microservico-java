package com.xxahrutoxx.clientAndPerson.persistences;

import com.xxahrutoxx.clientAndPerson.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends CrudRepository<Client, Long> {
}

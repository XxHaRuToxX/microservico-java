package com.xxahrutoxx.clientAndPerson.services.client;

import com.xxahrutoxx.clientAndPerson.entities.Client;
import com.xxahrutoxx.clientAndPerson.http.response.AccountByClientResponse;

import java.util.List;

public interface IClientService {
    List<Client> findAll();
    Client findById(Long id);
    Client save(Client client);
    Client update(Long id, Client client);
    AccountByClientResponse findAccountsByIdClient(Long idClient);
}

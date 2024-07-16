package com.xxahrutoxx.clientAndPerson.services.client;

import com.xxahrutoxx.clientAndPerson.Exceptions.ResourceNotFoundException;
import com.xxahrutoxx.clientAndPerson.client.IAccountClient;
import com.xxahrutoxx.clientAndPerson.dto.AccountDTO;
import com.xxahrutoxx.clientAndPerson.entities.Client;
import com.xxahrutoxx.clientAndPerson.http.response.AccountByClientResponse;
import com.xxahrutoxx.clientAndPerson.persistences.IClientRepository;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    private IClientRepository iClientRepository;
    @Autowired
    private IAccountClient iAccountClient;
    private final StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
    @Override
    public List<Client> findAll() {
        return (List<Client>) iClientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return iClientRepository.findById(id).orElseThrow();
    }

    @Override
    public Client save(Client client) {
        String encodedPassword = passwordEncryptor.encryptPassword(client.getPassword());
        client.setPassword(encodedPassword);
        return iClientRepository.save(client);
    }

    @Override
    public Client update(Long id, Client client) {
        Optional<Client> optionalClient = iClientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client clientExist= optionalClient.get();
            clientExist.setName(client.getName());
            clientExist.setGender(client.getGender());
            clientExist.setAge(client.getAge());
            clientExist.setIdentification(client.getIdentification());
            clientExist.setAddress(client.getAddress());
            clientExist.setPhone(client.getPhone());
            clientExist.setPassword(client.getPassword());
            clientExist.setState(client.isState());
            return iClientRepository.save(clientExist);
        } else {
            throw new ResourceNotFoundException("Client no found with id: " + id);
        }
    }

    @Override
    public AccountByClientResponse findAccountsByIdClient(Long idClient) {
        // Consultar el cliente
        Client client = iClientRepository.findById(idClient).orElse(new Client());
        // Obtener las cuentas
        List<AccountDTO> accountDTOList = iAccountClient.findAllAccountByClient(idClient);

        return AccountByClientResponse.builder()
                .clientName(client.getName())
                .identificationClient(client.getIdentification())
                .addressClient(client.getAddress())
                .phoneClient(client.getPhone())
                .accountDTOList(accountDTOList)
                .build();
    }
}

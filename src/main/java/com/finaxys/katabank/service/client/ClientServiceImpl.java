package com.finaxys.katabank.service.client;


import com.finaxys.katabank.entity.Client;
import com.finaxys.katabank.repositories.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client createClient(Client client) {
        if (isClientExists(client.getClientId()))
            throw new RuntimeException("Account already exists");
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        if (!isClientExists(client.getClientId()))
            throw new RuntimeException("Account not found");
        client.setLastUpdate(new Date());
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long clientId) {
        if (!isClientExists(clientId))
            throw new RuntimeException("Account not found");
        clientRepository.deleteById(clientId);
    }

    private boolean isClientExists(Long clientId) {
        return clientRepository.findById(clientId).isPresent();
    }
}
package com.finaxys.katabank.controller.client;

import com.finaxys.katabank.entity.Client;
import com.finaxys.katabank.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ClientController {

    @Autowired
    private final ClientService clientService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Client> findById(@PathVariable Long id) {
        return this.clientService.findById(id);
    }


    @GetMapping("/")
    List<Client> getClients() {
        return clientService.findAll();
    }


    @PostMapping("/createClient")
    Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @PutMapping("/updateClient")
    Client updateClient(@RequestBody Client client) {
        return clientService.updateClient(client);
    }

    @DeleteMapping("/delete/{clientId}")
    void deleteClient(@PathVariable Long clientId) {
        clientService.deleteClient(clientId);
    }

}

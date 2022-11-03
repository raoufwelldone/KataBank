package com.finaxys.katabank.repositories;

import com.finaxys.katabank.repositories.client.ClientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientControllerTest {

    @Autowired
    ClientRepository clientRepository;

    @Test
    public void itShouldReturnOneClient() {
        var ticketingClients = clientRepository.findAll();

        assertEquals(0, (long) ticketingClients.size());
    }
}

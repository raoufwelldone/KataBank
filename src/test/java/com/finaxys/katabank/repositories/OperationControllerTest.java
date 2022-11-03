package com.finaxys.katabank.repositories;


import com.finaxys.katabank.repositories.operation.OperationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OperationControllerTest {

    @Autowired
    OperationRepository operationRepository;

    @Test
    public void itShouldReturnOneOperation() {
        var ticketingOperations = operationRepository.findAll();

        assertEquals(0, ticketingOperations.size());
    }
}

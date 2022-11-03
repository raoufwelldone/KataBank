package com.finaxys.katabank.repositories;

import com.finaxys.katabank.repositories.account.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountIntegrationTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void itShouldReturnOneAccount() {
        var ticketingAccounts = accountRepository.findAll();

        assertEquals(0, (long) ticketingAccounts.size());
    }
}

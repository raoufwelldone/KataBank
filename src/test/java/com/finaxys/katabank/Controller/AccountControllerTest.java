package com.finaxys.katabank.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finaxys.katabank.controller.account.AccountController;
import com.finaxys.katabank.entity.Account;
import com.finaxys.katabank.service.account.AccountService;
import lombok.val;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = AccountController.class)
public class AccountControllerTest {

    static final String ROOT_URL = "/accounts";
    static final String accountId = "1-XXX";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    AccountService accountService;

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(accountService);
    }

    @Test
    public void itShouldReturn200ForFindById() throws Exception {
        val expectedAccount = new Account();

        when(accountService.findById(accountId)).thenReturn(Optional.of(expectedAccount));

        this.mockMvc.perform(
                get(ROOT_URL + "/" + accountId))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().json(objectMapper.writeValueAsString(expectedAccount)));

        verify(accountService, times(1)).findById(accountId);
    }

    @Test
    public void itShouldReturn200ForFindAll() throws Exception {
        val expectedList = List.of(new Account(),new Account());


        when(accountService.findAll()).thenReturn(expectedList);

        this.mockMvc.perform(
                get(ROOT_URL + "/"))
                .andExpect(status().is(HttpStatus.OK.value()));

        verify(accountService, times(1)).findAll();
    }


}

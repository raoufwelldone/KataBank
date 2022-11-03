package com.finaxys.katabank.service.account;


import com.finaxys.katabank.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    Optional<Account> findById(String id);

    Account createAccount(Account account);

    Account updateAccount(Account account);

    void deleteAccount(String accountId);

    List<Account> findAll();

    List<Account> findAccountsByClient(long clientId);

}

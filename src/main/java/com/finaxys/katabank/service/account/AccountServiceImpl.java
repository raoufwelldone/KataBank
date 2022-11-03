package com.finaxys.katabank.service.account;


import com.finaxys.katabank.entity.Account;
import com.finaxys.katabank.repositories.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Optional<Account> findById(String id) {
        return accountRepository.findById(id);
    }


    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> findAccountsByClient(long clientId) {
        return accountRepository.findAccountsByClient(clientId);
    }

    @Override
    public Account createAccount(Account account) {
        if (isAccountExists(account.getAccountId()))
            throw new RuntimeException("Account already exists");
        account.setBalance(50);
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Account account) {
        if (!isAccountExists(account.getAccountId()))
            throw new RuntimeException("Account not found");
        account.setLastUpdate(new Date());
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(String accountId) {
        if (!isAccountExists(accountId))
            throw new RuntimeException("Account not found");
        accountRepository.deleteById(accountId);
    }

    private boolean isAccountExists(String accountId) {
        return accountRepository.findById(accountId).isPresent();
    }


}

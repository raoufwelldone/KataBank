package com.finaxys.katabank.service.operation;


import com.finaxys.katabank.entity.Account;
import com.finaxys.katabank.entity.Deposit;
import com.finaxys.katabank.entity.Operation;
import com.finaxys.katabank.entity.Withdrawal;
import com.finaxys.katabank.repositories.account.AccountRepository;
import com.finaxys.katabank.repositories.operation.OperationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {


    private final OperationRepository operationRepository;

    private final AccountRepository accountRepository;

    @Override
    public Optional<Operation> findById(long id) {
        return operationRepository.findById(id);
    }

    @Override
    public List<Operation> findAll() {
        return operationRepository.findAll();
    }

    @Override
    public List<Operation> findAllOperationsByAccount(String accountId) {
        return operationRepository.findAllByAccountId(accountId);
    }

    @Override
    public void deposit(String accountId, double amount) {
        Account currentAccount = getAccount(accountId);
        Deposit deposit = Deposit.builder().operationDate(new Date()).amount(amount).account(currentAccount).build();
        saveOperation(deposit);
        currentAccount.setBalance(currentAccount.getBalance() + amount);
        accountRepository.save(currentAccount);
    }

    @Override
    public void withdrawal(String accountId, double amount) {
        Account currentAccount = getAccount(accountId);
        if (currentAccount.getBalance() + currentAccount.getDiscovered() < amount)
            throw new RuntimeException("insufficient balance");
        Withdrawal withdrawal = Withdrawal.builder().operationDate(new Date()).amount(amount).account(currentAccount).build();
        saveOperation(withdrawal);
        currentAccount.setBalance(currentAccount.getBalance() - amount);
        accountRepository.save(currentAccount);
    }

    @Override
    public void payment(String accountTransmitter, String accountBeneficiary, double amount) {
        if (accountTransmitter.equals(accountBeneficiary))
            throw new RuntimeException("impossible to perform the operation");
        withdrawal(accountTransmitter, amount);
        deposit(accountBeneficiary, amount);
    }

    @Override
    public void saveOperation(Operation operation) {
        operationRepository.save(operation);
    }

    public Account getAccount(String accountId) {
        if (accountRepository.findById(accountId).isPresent())
            throw new RuntimeException("Account not found");
        return accountRepository.findById(accountId).get();
    }
}

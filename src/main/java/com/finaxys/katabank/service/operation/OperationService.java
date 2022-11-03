package com.finaxys.katabank.service.operation;


import com.finaxys.katabank.entity.Operation;

import java.util.List;
import java.util.Optional;

public interface OperationService {

    Optional<Operation> findById(long id);

    List<Operation> findAll();

    List<Operation> findAllOperationsByAccount(String accountId);

    void deposit(String accountId, double amount);

    void withdrawal(String accountId, double amount);

    void payment(String accountTransmitter, String accountBeneficiary, double amount);

    void saveOperation(Operation operation);

}

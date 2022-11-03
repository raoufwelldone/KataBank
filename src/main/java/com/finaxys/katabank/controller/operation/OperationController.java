package com.finaxys.katabank.controller.operation;

import com.finaxys.katabank.entity.Operation;
import com.finaxys.katabank.service.operation.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/operations", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class OperationController {

    @Autowired
    private final OperationService operationService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Operation> findById(@PathVariable long id) {
        return operationService.findById(id);
    }

    @GetMapping("/accountId/{accountId}")
    List<Operation> getOperationByAccount(@PathVariable String accountId) {
        return operationService.findAllOperationsByAccount(accountId);
    }

    @GetMapping("/")
    List<Operation> getOperations() {
        return operationService.findAll();
    }

    @PostMapping("/deposit")
    void deposit(@RequestBody String accountId, @RequestBody double amount) {
        operationService.deposit(accountId, amount);
    }

    @PostMapping("/withdrawal")
    void withdrawal(@RequestBody String accountId, @RequestBody double amount) {
        operationService.withdrawal(accountId, amount);
    }


    @PostMapping("/payment")
    void payment(@RequestBody String accountTransmitter, @RequestBody String accountBeneficiary, @RequestBody double amount) {
        operationService.payment(accountTransmitter, accountBeneficiary, amount);
    }

}


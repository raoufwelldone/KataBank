package com.finaxys.katabank.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@Table(name = "WITHDRAWAL")
public class Withdrawal extends Operation {

    @Builder
    public Withdrawal(Date operationDate, double amount, Account account) {
        super(operationDate, amount, account);
    }
}

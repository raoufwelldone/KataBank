package com.finaxys.katabank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="OPERATION")
public abstract class Operation implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "OPERATION_ID", nullable = false)
    private Long operationId;

    @Column(name = "OPERATION_DATE")
    private Date operationDate;

    @Column(name = "AMOUNT")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT", referencedColumnName = "ACCOUNT_ID")
    private Account account;

    Operation(Date operationDate, double amount, Account account) {
        super();
        this.operationDate = operationDate;
        this.amount = amount;
        this.account = account;
    }
}

package com.finaxys.katabank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ACCOUNT")
public class Account implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ACCOUNT_ID", nullable = false)
    private String accountId;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "LAST_UPDATE")
    private Date lastUpdate;

    @Column(name = "BALANCE")
    private double balance;

    @Column(name = "DISCOVERED")
    private double discovered;

    @ManyToOne
    @JoinColumn(name = "CLIENT")
    private Client client;

    @OneToMany(mappedBy = "account")
    private List<Operation> operations;

}

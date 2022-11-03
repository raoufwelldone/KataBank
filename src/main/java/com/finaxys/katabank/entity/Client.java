package com.finaxys.katabank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "Client")
public class Client implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "CLIENT_ID", nullable = false)
    private Long clientId;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "LAST_UPDATE")
    private Date lastUpdate;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private Number phone;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Account> accounts;

}

package com.finaxys.katabank.repositories.account;


import com.finaxys.katabank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    @Query("SELECT u FROM Account u WHERE u.client.clientId = ?1")
    List<Account> findAccountsByClient(long clientId);

}

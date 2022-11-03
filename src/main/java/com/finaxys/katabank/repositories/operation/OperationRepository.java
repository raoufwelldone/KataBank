package com.finaxys.katabank.repositories.operation;


import com.finaxys.katabank.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

    @Query("SELECT u FROM Operation u WHERE u.account.accountId = ?1")
    List<Operation> findAllByAccountId(String accountId);

}

package com.example.Assignment2.Repository;

import com.example.Assignment2.Models.Trans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransInterface extends JpaRepository<Trans,Integer> {

    public Iterable<Trans> findByTxnId(Integer txnId);
    public Iterable<Trans> findByPayee(Long payee);
    public Iterable<Trans> findByPayer(Long payer);

}

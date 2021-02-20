package com.example.Assignment2.Wallet.Repository;

import com.example.Assignment2.Wallet.Models.Trans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransInterface extends JpaRepository<Trans,Integer> {

    public Iterable<Trans> findByTxnId(Integer txnId);
    public Iterable<Trans> findByPayee(Long payee);
    public Iterable<Trans> findByPayer(Long payer);

}

package com.example.Assignment2.Wallet.Service;

import com.example.Assignment2.Wallet.Models.Trans;
import com.example.Assignment2.Wallet.Repository.TransInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransService {

    @Autowired
    private TransInterface transInterface;

    public Trans feedInDB(Trans trans){
        return transInterface.save(trans);
    }

    public Iterable<Trans> getAll(){
        return transInterface.findAll();
    }

    public Optional<Trans> getTxn(Integer txnId){
        return transInterface.findById(txnId);
    }

    public List<Trans> findByPayee(Long payee){
        return (List<Trans>) transInterface.findByPayee(payee);
    }

    public List<Trans> findByPayer(Long payer){
        return (List<Trans>) transInterface.findByPayer(payer);
    }

}

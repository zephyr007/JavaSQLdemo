package com.example.Assignment2.Wallet.Service;

import com.example.Assignment2.Wallet.Models.Wallet;
import com.example.Assignment2.Wallet.Repository.WalletInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    @Autowired
    private WalletInterface walletInterface;

    public Optional<Wallet> findById(Long id){
        return walletInterface.findById(id);
    }

    public List<Wallet> findAll(){
        return walletInterface.findAll();
    }

    public Wallet save(Wallet wallet){
        return walletInterface.save(wallet);
    }

}

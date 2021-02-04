package com.example.Assignment2.Service;

import com.example.Assignment2.Models.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface WalletInterface extends CrudRepository<Wallet, Long> {
}

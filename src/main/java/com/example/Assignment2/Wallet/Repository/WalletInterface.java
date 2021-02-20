package com.example.Assignment2.Wallet.Repository;

import com.example.Assignment2.Wallet.Models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WalletInterface extends JpaRepository<Wallet, Long> {

}

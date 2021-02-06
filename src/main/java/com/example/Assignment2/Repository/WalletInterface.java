package com.example.Assignment2.Repository;

import com.example.Assignment2.Models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WalletInterface extends JpaRepository<Wallet, Long> {

}

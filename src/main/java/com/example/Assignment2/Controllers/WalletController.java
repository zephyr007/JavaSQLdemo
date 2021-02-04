package com.example.Assignment2.Controllers;

import com.example.Assignment2.Models.Wallet;
import com.example.Assignment2.Service.WalletInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/wallet")
public class WalletController {

    @Autowired
    private WalletInterface walletInterface;

    @PostMapping
    public @ResponseBody
    Wallet createWallet(@RequestParam Long phoneNo){
        System.out.println("Wallet API called");
        if(walletInterface.findById(phoneNo).isPresent())
        {
            System.out.println("Wallet Already exists for "+phoneNo);
            return null;
        }

        Wallet wallet=new Wallet(phoneNo);
//        wallet.setWalletId(phoneNo);
//        wallet.setAmount(0);

        System.out.println("Wallet created for "+phoneNo);
        return walletInterface.save(wallet);
    }

    @GetMapping
    public @ResponseBody
    Iterable<Wallet> getAll(){
        return walletInterface.findAll();
    }

}

/***
 * Wallet Management
 *
 *
 * 1. Create Wallet: API which will create wallet for a user
 * url:http://localhost:8080/wallet
 * METHOD : POST
 * input: phone number
 * Validations : phone number should exist , only one wallet for a user.
 *
 * 2.API to transfer money from one wallet to another wallet (p2p).
 * url:http://localhost:8080/transaction
 * METHOD : POST
 * input:{payer_phone_number,payee_phone_number,amount}
 * Validations : payer and payee both should exist, payer should have sufficient balance.
 *
 * 3.Transaction Summary API
 * url:http://localhost:8080/transaction?userId=<userId>
 * METHOD: GET
 * Validations: userId should exists
 * Note : this api should return in a pagination way.
 *
 * 4.Transaction Status
 * url:http://localhost:8080/transaction?txnId=<txnID>
 * Method :GET
 * Validation: TransactionId should exists
 *
 * Expectations:
 * =============
 * Flow Diagram in UML
 * Schema Design
 * Code with proper comment
 * Junit Test cases
 * ***/

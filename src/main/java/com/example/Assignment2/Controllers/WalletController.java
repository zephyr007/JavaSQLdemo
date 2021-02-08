package com.example.Assignment2.Controllers;

import com.example.Assignment2.Models.Wallet;
import com.example.Assignment2.Repository.WalletInterface;
import com.example.Assignment2.Service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/wallet")
public class WalletController {

    //Using Service to interact with Db
    @Autowired
    public WalletService walletInterface;

    //Creatig Wallet API
    @PostMapping
    public @ResponseBody
    Wallet createWallet(@RequestParam Long phoneNo){
        System.out.println("Wallet POST API called");

        //Check if it already exists
        if(walletInterface.findById(phoneNo).isPresent())
        {
            System.out.println("Wallet Already exists for "+phoneNo);
            return null;
        }

        //Create New Wallet
        Wallet wallet=new Wallet();
        wallet.setWalletId(phoneNo);
        wallet.setAmount(100);

        System.out.println("Wallet created for "+phoneNo);
        //saving and returning Wallet
        return walletInterface.save(wallet);
    }

    //finding All Wallets
    @GetMapping
    public @ResponseBody
    Iterable<Wallet> getAll(){

        System.out.println("Wallet Get API Called");
        return walletInterface.findAll();
    }

    //Updating/Adding Balance
    @PutMapping
    public Wallet addBalance(@RequestParam Long phoneNo,@RequestParam int bal){
        System.out.println("PUT Wallet API");
        if(!walletInterface.findById(phoneNo).isPresent()){
            System.out.println("Wallet doesn`t exist");
        }
        Wallet wallet=walletInterface.findById(phoneNo).get();
        wallet.setAmount(wallet.getAmount()+bal);
        return walletInterface.save(wallet);
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

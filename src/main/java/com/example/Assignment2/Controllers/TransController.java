package com.example.Assignment2.Controllers;

import com.example.Assignment2.Models.Trans;
import com.example.Assignment2.Models.TransWithoutID;
import com.example.Assignment2.Models.Wallet;
import com.example.Assignment2.Service.TransInterface;
import com.example.Assignment2.Service.WalletInterface;
import javassist.bytecode.Descriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

@Controller
public class TransController{

    @Autowired
    private TransInterface transInterface;

    @Autowired
    private WalletInterface walletInterface;

    @PostMapping(path = "/transaction")
    public @ResponseBody
    Trans makeTxn(@RequestBody TransWithoutID transWithoutID){
        /*** Transaction Verification Steps**/
        if(!walletInterface.findById(transWithoutID.getPayee_phone_number()).isPresent()){
            System.out.println("payee wallet doesn`t exits");
            return null;
        }
        if(!walletInterface.findById(transWithoutID.getPayer_phone_number()).isPresent()){
            System.out.println("payer wallet doesn`t exits");
            return null;
        }
        Wallet walletpayer=walletInterface.findById(transWithoutID.getPayer_phone_number()).get();

        if(walletpayer.getAmount()<transWithoutID.getAmount()){
            System.out.println("Insufficient balance");
            return null;
        }
        Wallet walletpayee=walletInterface.findById(transWithoutID.getPayee_phone_number()).get();

        Trans trans=new Trans(transWithoutID.getPayer_phone_number(),
                transWithoutID.getPayee_phone_number(),
                transWithoutID.getAmount());

        walletpayer.setAmount(walletpayer.getAmount()-transWithoutID.getAmount());
        walletpayee.setAmount(walletpayee.getAmount()+transWithoutID.getAmount());
//        walletpayee.addTxn(trans.getTxnId());
//        walletpayer.addTxn(trans.getTxnId());

        walletInterface.save(walletpayee);
        walletInterface.save(walletpayer);


        return transInterface.save(trans);
    }

    @GetMapping(path = "/transaction")
    public @ResponseBody
    Iterable<Trans> getAllTrans(){
        return transInterface.findAll();
    }

    @GetMapping(path = "/transactionStatus")
    public @ResponseBody
    String checkTxnStatus(@RequestParam Integer TxnId){
        if(transInterface.findById(TxnId).isPresent()){
            String res="";
            Trans trans=transInterface.findById(TxnId).get();
            res+="Transaction Succesful ID:"+trans.getTxnId()+" payer: "+trans.getPayer()+" payee: "+trans.getPayee()+" amount: "+trans.getAmount();
            return res;
        }
        return "Txn Failed or Doesn`t exists";
    }

    @GetMapping(path = "/transactionsBy")
    public @ResponseBody
    ArrayList<Trans> getAlltrans(@RequestParam Long userId){
        System.out.println("Transaction Summary API");
        if(!walletInterface.findById(userId).isPresent()){
            System.out.println("User does not exits");
            return null;
        }
        ArrayList<Trans> list=new ArrayList<Trans>();

//        Itrating through these items

        Iterable<Trans> transIterable=transInterface.findAll();
        Iterator<Trans> itr=transIterable.iterator();
        while (itr.hasNext()){
            Trans added= itr.next();
            if(added.getPayer().equals(userId))
            {
//                Trans added= itr.next();
                System.out.println("Txn Added "+added.getPayer()+" to "+added.getPayee()+" amount:"+added.getAmount());
                list.add(added);
            }
        }
        System.out.println("Size of transactions by user"+list.size());

        return list;
    }
}
/***
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

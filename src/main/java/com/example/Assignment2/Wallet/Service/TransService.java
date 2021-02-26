package com.example.Assignment2.Wallet.Service;

import com.example.Assignment2.Wallet.Models.Trans;
import com.example.Assignment2.Wallet.Models.TransWithoutID;
import com.example.Assignment2.Wallet.Models.Wallet;
import com.example.Assignment2.Wallet.Repository.TransInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TransService {

    @Autowired
    private TransInterface transInterface;

    @Autowired
    private WalletService walletService;

    public Trans feedInDB(Trans trans){
        return transInterface.save(trans);
    }

//    @Transactional :Look into it
    public Trans CheckTrans(TransWithoutID transWithoutID){
        boolean checkflag=false;
        if(transWithoutID.getAmount()<0)
        {
            System.out.println("Invalid Amount");
            return null;
        }
        if(!walletService.findById(transWithoutID.getPayee_phone_number()).isPresent()){
            System.out.println("payee wallet doesn`t exits");
            return null;
        }
        if(!walletService.findById(transWithoutID.getPayer_phone_number()).isPresent()){
            System.out.println("payer wallet doesn`t exits");
            return null;
        }
        Wallet walletpayer=walletService.findById(transWithoutID.getPayer_phone_number()).get();

        if(walletpayer.getAmount()<transWithoutID.getAmount()){
            System.out.println("Insufficient balance");
            checkflag=true;
//            return null;
        }
        Wallet walletpayee=walletService.findById(transWithoutID.getPayee_phone_number()).get();

        Trans trans=new Trans(transWithoutID.getPayer_phone_number(),
                transWithoutID.getPayee_phone_number(),
                transWithoutID.getAmount());

        if(checkflag!=true) {

            walletpayer.setAmount(walletpayer.getAmount() - transWithoutID.getAmount());
            walletpayee.setAmount(walletpayee.getAmount() + transWithoutID.getAmount());

            //Locking Funda: lock :Saving into Database @Transational: how database transactions work
            walletService.save(walletpayee);
            walletService.save(walletpayer);
        }
        else
        {
            trans.setStatus(false);
        }
        return trans;
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

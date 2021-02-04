package com.example.Assignment2.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Wallet {

    @Id
    public Long walletId;
    public int amount;
    public static ArrayList<UUID> TransactionList;


    public Wallet(Long walletId){
        this.walletId=walletId;
        this.amount=0;
        TransactionList=new ArrayList<UUID>();
    }

    public void addTxn(UUID txnId){
        if(txnId!=null) {
            this.TransactionList.add(txnId);
        }
    }

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}

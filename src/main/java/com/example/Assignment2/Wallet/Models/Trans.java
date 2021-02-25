package com.example.Assignment2.Wallet.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Trans {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer txnId;

    public Long payer;
    public Long payee;
    public int amount;
    public Timestamp timestamp;
    public Boolean Status;

    public Trans(Long payer,Long payee,int amount){
//        this.txnId=UUID.randomUUID();
        this.payer=payer;
        this.payee=payee;
        this.amount=amount;
        Status=true;
        timestamp=new Timestamp(System.currentTimeMillis());
    }
}

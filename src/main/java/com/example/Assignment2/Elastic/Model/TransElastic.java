package com.example.Assignment2.Elastic.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.sql.Timestamp;

@Document(indexName = "my-application",indexStoreType = "TransElastic",shards = 2)
public class TransElastic {

    @Id
    public Integer TxnId;
    public Long payer;
    public Long payee;
    public int amount;
    public Timestamp timestamp;
    public Boolean Status;

    public TransElastic(Integer txnId,Long payer, Long payee, int amount) {
        TxnId = txnId;
        this.payer = payer;
        this.payee = payee;
        this.amount = amount;
        Status=true;
        timestamp=new Timestamp(System.currentTimeMillis());
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Integer getTxnId() {
        return TxnId;
    }

    public void setTxnId(Integer txnId) {
        TxnId = txnId;
    }

    public Long getPayer() {
        return payer;
    }

    public void setPayer(Long payer) {
        this.payer = payer;
    }

    public Long getPayee() {
        return payee;
    }

    public void setPayee(Long payee) {
        this.payee = payee;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}

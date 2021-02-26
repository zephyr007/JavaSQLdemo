package com.example.Assignment2.Elastic.Model;

import com.sun.jmx.snmp.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "my-application",indexStoreType = "Transactions",shards = 1)
public class TransElastic {

    @Id
    public Integer txnId;
    public Long payer;
    public Long payee;
    public int amount;
    //Find out this error as well
//    public Timestamp timestamp;
    public Boolean Status;

    public TransElastic(Integer txnId,Long payer, Long payee, int amount) {
        this.txnId = txnId;
        this.payer = payer;
        this.payee = payee;
        this.amount = amount;
        Status=true;
//        timestamp=new Timestamp(System.currentTimeMillis());
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

//    public Timestamp getTimestamp() {
//        return timestamp;
//    }

    public Integer getTxnId() {
        return txnId;
    }

    public void setTxnId(Integer txnId) {
        txnId = txnId;
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

package com.example.Assignment2.Elastic.Service;

import com.example.Assignment2.Elastic.Model.TransElastic;
import com.example.Assignment2.Elastic.Repo.ElasticSearchRepo;
import com.example.Assignment2.Wallet.Models.Trans;
import com.example.Assignment2.Wallet.Models.TransWithoutID;
import com.example.Assignment2.Wallet.Service.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElasticService {

    @Autowired
    ElasticSearchRepo elasticSearchRepo;
    @Autowired
    private TransService transService;

    public Iterable<TransElastic> getPayerNo(long payer){
        return (Iterable<TransElastic>) elasticSearchRepo.findAllBypayer(payer);
    }

    public Iterable<TransElastic> getPayeeNo(long payee){
        return elasticSearchRepo.findAllBypayee(payee);
    }

    public Iterable<TransElastic>getAllTrans(){
        return elasticSearchRepo.findAll();
    }

    public TransElastic saveTrans(Integer txnid,TransWithoutID transWithoutID){

        Trans trans=transService.CheckTrans(transWithoutID);

        TransElastic newTrans=new TransElastic(txnid,trans.getPayer(),trans.getPayee(),trans.getAmount());
        newTrans.setStatus(true);

        elasticSearchRepo.save(newTrans);
        System.out.println("Transaction Saved on Elastic: "+newTrans.txnId+" saved on ELasticSearch");

        return newTrans;
    }
}

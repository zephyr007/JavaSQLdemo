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

    public TransElastic saveTrans(TransWithoutID transWithoutID){
        Trans trans=transService.CheckTrans(transWithoutID);

        TransElastic newTrans=new TransElastic(trans.getTxnId(),trans.getPayer(),trans.getPayee(),trans.getAmount());
        elasticSearchRepo.save(newTrans);

        return newTrans;
    }
}

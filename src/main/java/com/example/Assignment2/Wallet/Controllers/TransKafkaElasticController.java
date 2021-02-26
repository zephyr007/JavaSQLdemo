package com.example.Assignment2.Wallet.Controllers;

import com.example.Assignment2.Elastic.Model.TransElastic;
import com.example.Assignment2.Elastic.Repo.ElasticSearchRepo;
import com.example.Assignment2.Elastic.Service.ElasticService;
import com.example.Assignment2.Kafka.Consumer.KafkaConsumer;
import com.example.Assignment2.Kafka.Publisher.KafkaPublisher;
import com.example.Assignment2.Wallet.Models.Trans;
import com.example.Assignment2.Wallet.Models.TransWithoutID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@Service
@RequestMapping("/elastic")
public class TransKafkaElasticController {

    @Autowired
    private  KafkaPublisher kafkaPublisher;

    @Autowired
    private ElasticService elasticService;

    @Autowired
    ElasticSearchRepo elasticSearchRepo;

    @Autowired
    KafkaConsumer kafkaConsumer;

//    TransWithoutID passedTrans=new TransWithoutID();
//
//    @KafkaListener(topics = "KafkaExample11",groupId = "group_json",containerFactory = "transWithoutIDKafkaListenerFactory")
//    public TransWithoutID getTransactionsFromKafka(TransWithoutID user1) {
//        TransWithoutID user=new TransWithoutID(user1.getPayer_phone_number(),user1.getPayee_phone_number(), user1.getAmount());
//        System.out.println("Consumed Transaction: " + user.getPayee_phone_number()+" to "+user.getPayer_phone_number()+" Amount: "+user.getAmount());
//        passedTrans=user;
//        return passedTrans;
//    }

//    public void updatePassedTrans(){
//        passedTrans=
//    }

    @GetMapping("/allTrans")
    public Iterable<TransElastic> getAll(){
        return elasticService.getAllTrans();
//        return elasticService.getAllTrans();
    }

    @PostMapping("/transaction")
    public Trans transWithKafkaElasti(@RequestBody TransWithoutID transWithoutID){

        Trans txn=kafkaPublisher.publishTrans(transWithoutID);
        TransWithoutID passedTrans=kafkaConsumer.getTransactionsFromKafka(transWithoutID);
        //wait for a sec here till its get updated to kafka
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Transaction passing to Elastic here");
        System.out.println("Elastic Transaction: " + passedTrans.getPayee_phone_number()+" to "+passedTrans.getPayer_phone_number()+" Amount: "+passedTrans.getAmount());

//        new TransElastic()
        /****PUT ELastic search Implementation here*****/
        TransElastic t=elasticService.saveTrans(txn);

        return txn;
    }
}

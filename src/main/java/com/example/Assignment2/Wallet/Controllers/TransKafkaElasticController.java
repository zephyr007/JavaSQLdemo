package com.example.Assignment2.Wallet.Controllers;

import com.example.Assignment2.Elastic.Model.TransElastic;
import com.example.Assignment2.Elastic.Service.ElasticService;
import com.example.Assignment2.Kafka.Consumer.KafkaConsumer;
import com.example.Assignment2.Kafka.Publisher.KafkaPublisher;
import com.example.Assignment2.Wallet.Models.TransWithoutID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/elastic")
public class TransKafkaElasticController {

    @Autowired
    private  KafkaPublisher kafkaPublisher;

    @Autowired
    private ElasticService elasticService;

    TransWithoutID passedTrans=new TransWithoutID();

    @KafkaListener(topics = "KafkaExample11",groupId = "group_json",containerFactory = "transWithoutIDKafkaListenerFactory")
    public void getTransactionsFromKafka(TransWithoutID user1) {
        TransWithoutID user=new TransWithoutID(user1.getPayer_phone_number(),user1.getPayee_phone_number(), user1.getAmount());
        System.out.println("Consumed Transaction: " + user.getPayee_phone_number()+" to "+user.getPayer_phone_number()+" Amount: "+user.getAmount());
        passedTrans=user;
    }

//    public void updatePassedTrans(){
//        passedTrans=
//    }

    @PostMapping("/Trans")
    public TransElastic transWithKafkaElasti(@RequestBody TransWithoutID transWithoutID){

        Integer txnid=kafkaPublisher.publishTrans(transWithoutID);
        //wait for a sec here till its get updated to kafka

        System.out.println("Transaction passing to Elastic here");
        System.out.println("Consumed Transaction: " + passedTrans.getPayee_phone_number()+" to "+passedTrans.getPayer_phone_number()+" Amount: "+passedTrans.getAmount());

//        new TransElastic()
        /****PUT ELastic search Implementation here*****/
        TransElastic t=elasticService.saveTrans(txnid,passedTrans);

        return t;
    }
}

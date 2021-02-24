package com.example.Assignment2.Kafka.Consumer;

import com.example.Assignment2.Wallet.Models.TransWithoutID;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//@Service
public class KafkaConsumer {

    /*****
     * Kafka Listener Example
     * Used in Wallet.Controllers.TransKafkaElasticController
     *
     * *****/
//    @KafkaListener(topics = "KafkaExample11",groupId = "group_json",containerFactory = "transWithoutIDKafkaListenerFactory")
//    public TransWithoutID getTransactionsFromKafka(TransWithoutID user1) {
//        TransWithoutID user=new TransWithoutID(user1.getPayer_phone_number(),user1.getPayee_phone_number(), user1.getAmount());
//        System.out.println("Consumed Transaction Message: " + user.getPayee_phone_number()+" to "+user.getPayer_phone_number()+" Amount: "+user.getAmount());
//        return user;
//    }

}

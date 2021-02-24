package com.example.Assignment2.Kafka.Publisher;

import com.example.Assignment2.Wallet.Models.Trans;
import com.example.Assignment2.Wallet.Models.TransWithoutID;
import com.example.Assignment2.Wallet.Service.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaPublisher {

    @Autowired
    public KafkaTemplate<String, TransWithoutID> kafkaTemplate;
    @Autowired
    public TransService transService;

    private static String topic="KafkaExample11";

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @PostMapping("publish/Trans")
    public Integer publishTrans(@RequestBody TransWithoutID transWithoutID){

        Trans trans=transService.CheckTrans(transWithoutID);
        if(trans==null)
        {
            String res= "Transaction Failed";
            System.out.println(res);
        }

        TransWithoutID newTrans=new TransWithoutID(trans.getPayer(),trans.getPayee(),trans.getAmount());
        kafkaTemplate.send(topic,newTrans);
        transService.feedInDB(trans);

        String res="Transaction published ";
        System.out.println(res);
        return trans.getTxnId();
    }

}

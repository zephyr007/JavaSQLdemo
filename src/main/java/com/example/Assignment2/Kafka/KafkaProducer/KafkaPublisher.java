package com.example.Assignment2.Kafka.KafkaProducer;

import com.example.Assignment2.Kafka.Model.WalletMsgModel;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka")
public class KafkaPublisher {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

//    @Autowired
//    KafkaTemplate<String, WalletMsgModel> WalletkafkaTemplate;

    private static String Topic="Kafka_Example";

    @GetMapping("/hello")
    public String hello(){
        System.out.println("Kafka Sever Works");
        return "Hello World Kafka Srver";

    }

    @PostMapping("/publish")
    public String printmsg(@RequestParam String message){
        kafkaTemplate.send(Topic,message);
        String res="Message Published :"+message+" on topic: "+Topic;
        System.out.println(res);
        return res;
    }

//    @PostMapping("/Walletpublish")
//    public String printmsg(@RequestBody WalletMsgModel message){
//        WalletkafkaTemplate.send(Topic,new WalletMsgModel(message.getPhoneNo(),message.getEventType(),message.getMessage()));
//        String res="Wallet Message Published : on topic: "+Topic;
//        System.out.println(res);
//        return res;
//    }



    //to get message on kafka whenever a  event occurs on a topic
    // like :Wallet create waller, update bal
    // transaction :Transacation Added on server
    public String kafkapublish(String topic,String message){
        if(topic==null)
            kafkaTemplate.send(Topic,message);
        kafkaTemplate.send(topic,message);
        String res="Topic Printed on Kafka Message Board : "+topic+":: "+message;
        return res;
    }
}

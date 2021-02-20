package com.example.Assignment2.Kafka.Config;

import com.example.Assignment2.Kafka.Model.WalletMsgModel;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class WalletKafkaMsgConfig {

    //we need to configure kafka for other than String value
//    @Bean
//    ProducerFactory<String, WalletMsgModel> producerFactory(){
//        Map<String,Object> config =new HashMap<>();
//
//        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
//        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//
//        return new DefaultKafkaProducerFactory<>(config);
//    }
//
//    @Bean
//    KafkaTemplate<String,WalletMsgModel> kafkaTemplate(){
//        return new KafkaTemplate<>(producerFactory());
//    }
}

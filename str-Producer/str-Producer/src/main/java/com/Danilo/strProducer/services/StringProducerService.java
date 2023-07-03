package com.Danilo.strProducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

// Esta classe envia as mensagens para o topic
@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage (String message){
        kafkaTemplate.send("strTopic", message).addCallback(
         success -> {
             if (success != null){
                 log.info("Send Message with sucess ()", message);
                         log.info("Partition {}, offset{}",
                                 success.getRecordMetadata().partition(),
                                 success.getRecordMetadata().offset()
                         );
           }
         },
         error -> log.error ("Error send message")
        );
    }
}

package com.Danilo.strConsumer.listener;


import com.Danilo.strConsumer.custom.StrConsumerCustomListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {
//Consumidor original
   /* @KafkaListener(groupId = "group-1", topics = "strTopic", containerFactory = "strContainerFactory")
    public  void listener(String message){
        log.info("Receive message {}",message);
    }*/

//Definindo qual é a partição que o consumidro vai se inscrever
 /*   @KafkaListener(groupId = "group-1",
            topicPartitions ={
        @TopicPartition(topic = "strTopic",partitions = {"0"})
            }, containerFactory = "strContainerFactory")*/
 //  Como foi estilizado o listener essa para supeior sai e vem a customização feita na classe StroCosumerCostumerListener

 @StrConsumerCustomListener(groupId = "group-1")
    public  void LOG (String message){
        log.info("LOG ::: Receive message {}",message);
    }

    //teste que mostram que podem haver vários consumidore para o mesmo topic
    // Defini que esse consumidor estara na partition 1 qaundo for consumir
   /* @KafkaListener(groupId = "group-1",
            topicPartitions = {
            @TopicPartition(topic = "strTopic",partitions = {"1"})
            }
            , containerFactory = "strContainerFactory")*/
    @StrConsumerCustomListener(groupId = "group-1")
    public  void CRATE(String message){
        log.info("CREATE ::: Receive message {}",message);
    }

    //A principio só tem duas partição sendon assim esse aqui vai mudar de grupo e vai estar assinado nas duas pois no grupo 1 já esta preenchido
   /* @KafkaListener(groupId = "group-2", topics = "strTopic", containerFactory = "strContainerFactory")*/
    @StrConsumerCustomListener(groupId = "group-2")
    public  void HISTORY(String message){
        log.info("HISTORY ::: Receive message {}",message);
    }

}




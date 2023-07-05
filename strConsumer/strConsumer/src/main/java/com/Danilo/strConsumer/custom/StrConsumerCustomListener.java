package com.Danilo.strConsumer.custom;


import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@KafkaListener
public @interface StrConsumerCustomListener {
    //Ouvindo customizado de consumidor de string

    @AliasFor(annotation = KafkaListener.class,attribute = "topics")
    String[] topics() default "strTopic";

    // nesse metodo estou dizendo: containerFactory padrão sera o strContainerFactory
    @AliasFor(annotation = KafkaListener.class, attribute = "containerFactory")
    String containerFactory() default "strContainerFactory";

    // definindo o grupo de consumo
   @AliasFor(annotation = KafkaListener.class, attribute = "groupId")
    String groupId() default "";
}

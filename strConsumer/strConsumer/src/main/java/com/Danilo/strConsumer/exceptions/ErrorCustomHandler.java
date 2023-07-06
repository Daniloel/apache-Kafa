package com.Danilo.strConsumer.exceptions;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

// Esta classe vai customizar a excessoes de erros, para não poluir a tela
@Log4j2
@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {


    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException e) {
        log.info("EXCEPTION_HANDLER ::: Capiturei um erro");
        log.info("Payload::: {}", message.getPayload());
        log.info("HEadres ::: {}",message.getHeaders());
        log.info("offset :::{}",message.getHeaders().get("Kafaka_offset"));
        log.info("Message exception :::{}",e.getMessage() );
        return null;
    }

   /* @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {
        return KafkaListenerErrorHandler.super.handleError(message, exception, consumer);
    }*/
}

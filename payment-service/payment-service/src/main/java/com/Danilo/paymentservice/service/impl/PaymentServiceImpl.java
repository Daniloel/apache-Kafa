package com.Danilo.paymentservice.service.impl;

import com.Danilo.paymentservice.model.Payment;
import com.Danilo.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@RequiredArgsConstructor
@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {

     private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @SneakyThrows
    @Override
    public void sendPayment(Payment payment) {
        log.info("Recebi o pagamento {}",payment);
        Thread.sleep(1000);

        log.info("Enviado o pagamento...");
        kafkaTemplate.send("payment-topic",payment);

    }


}

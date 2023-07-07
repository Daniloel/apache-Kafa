package com.Danilo.paymentservice.service.impl;

import com.Danilo.paymentservice.model.Payment;
import com.Danilo.paymentservice.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class PaymentServcieImpl implements PaymentService {

    @Override
    public void sendPayment(Payment payment) {
        log.info("PAYMENT_SERVICE_IMPL::: Recebi o pagamento {}",payment);

    }
}

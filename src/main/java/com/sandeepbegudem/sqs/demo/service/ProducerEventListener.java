package com.sandeepbegudem.sqs.demo.service;

import com.sandeepbegudem.sqs.demo.model.ProductEvent;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class ProducerEventListener {

    @SqsListener("sandeepbegudem-queue")
    public void listenEvents(ProductEvent event ) {
        System.out.println("Received Product Event: " + event);
    }
}

package com.sandeepbegudem.sqs.demo.service;

import com.sandeepbegudem.sqs.demo.model.ProductEvent;
import com.sandeepbegudem.sqs.demo.model.ProductEventType;
import org.springframework.stereotype.Service;
import io.awspring.cloud.sqs.operations.SqsTemplate;

import java.time.Instant;
import java.util.UUID;

@Service
public class ProductEventProducer {

    private final SqsTemplate sqsTemplate;

    public ProductEventProducer(SqsTemplate sqsTemplate) {
        this.sqsTemplate = sqsTemplate;
    }

    public void publishEvents(String queueName, ProductEvent event) {
        ProductEvent product = new ProductEvent();
        product.setEventId(UUID.randomUUID().toString());
        product.setEventType(ProductEventType.PRODUCT_CREATED);
        product.setProduct(event.getProduct());
        product.setEventTime(Instant.now());

        sqsTemplate.send(x -> x.queue(queueName).payload(product));
    }
}

package com.sandeepbegudem.sqs.demo.controller;

import com.sandeepbegudem.sqs.demo.model.Product;
import com.sandeepbegudem.sqs.demo.model.ProductEvent;
import com.sandeepbegudem.sqs.demo.service.ProductEventProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductEventProducer producer;

    public ProductController(ProductEventProducer producer) {
        this.producer = producer;
    }
    @Value("${queue.name}")
    private String queue;

    @PostMapping("/publish")
    public String createProduct(@RequestBody ProductEvent product) {
        producer.publishEvents(queue, product);
        return "New event successfully published 🎉🎉🎉";
    }
}

package com.sandeepbegudem.sqs.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEvent {

    private String eventId;
    private ProductEventType eventType;
    private Product product;
    private Instant eventTime;
}

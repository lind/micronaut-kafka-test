package org.example.kafka;

import io.micronaut.configuration.kafka.annotation.*;

import javax.inject.Inject;

@KafkaListener(offsetReset = OffsetReset.EARLIEST,
        offsetStrategy = OffsetStrategy.DISABLED,
        groupId = "test-listener")
public class TestListener {

    @Inject
    Holder holder;

    @Topic(value = "test_topic")
    public void receive(@KafkaKey String key, String value) {
        System.out.println("Received: key: " + key + ", value: " + value);

        holder.setMessage(value);
    }
}

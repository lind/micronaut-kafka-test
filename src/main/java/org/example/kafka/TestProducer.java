package org.example.kafka;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient("test-producer")
public interface TestProducer {

    @Topic("test_topic")
    public void send(@KafkaKey String key, String value);

}

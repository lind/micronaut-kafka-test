package org.example.testing

import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaClient("test-producer")
interface TestProducer {

    @Topic("test_topic")
    fun send(@KafkaKey key: String, value: String)

}
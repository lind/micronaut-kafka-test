package org.example.testing

import io.micronaut.configuration.kafka.annotation.*
import javax.inject.Inject

@KafkaListener(offsetReset = OffsetReset.EARLIEST, offsetStrategy = OffsetStrategy.DISABLED, groupId = "\${test-listener.group-id}")
class TestListener {

    @Inject
    internal var holder: Holder? = null

    @Topic("test_topic")
    fun receive(@KafkaKey key: String, value: String) {
        println("Received: key: $key, value: $value")

        println("holder id:${holder}")
        holder!!.message = value
    }
}

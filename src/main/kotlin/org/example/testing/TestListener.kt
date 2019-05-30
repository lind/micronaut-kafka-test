package org.example.t

import io.micronaut.configuration.kafka.annotation.*
import javax.inject.Inject

@KafkaListener(offsetReset = OffsetReset.EARLIEST, offsetStrategy = OffsetStrategy.DISABLED, groupId = "test-listener")
class TestListener {

    @Inject
    internal var holder: Holder? = null

    @Topic("test_topic")
    fun receive(@KafkaKey key: String, value: String) {
        println("Received: key: $key, value: $value")

        holder!!.message = value
    }
}

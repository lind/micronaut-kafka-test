package org.example.kafka

import io.micronaut.context.ApplicationContext
import org.junit.jupiter.api.Test

class Testing {

    var ctx = ApplicationContext.run()
    val container = ctx.getBean(Container::class.java)

    @Test
    fun tesing() {
        println("******************************************")
        println("Yes!!!")
        println("******************************************")

        println("Container:${container.holder}")
    }
}
package org.example.t

import io.micronaut.runtime.Micronaut
import org.example.kafka.Application

object Application {

    @JvmStatic
    fun main(args: Array<String>) {

        Micronaut.run(Application::class.java)
    }

}
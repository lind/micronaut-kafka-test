package org.example.testing

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {

        Micronaut.run(Application::class.java)
    }

}
package org.example.testing

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {

        println("Starting!")

        Micronaut.build()
                .packages("org.example.testing")
                .mainClass(Application.javaClass)
                .start()    }

}
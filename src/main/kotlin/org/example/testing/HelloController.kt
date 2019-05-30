package org.example.testing

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import javax.inject.Inject

@Controller("/hello")
class HelloController {

    @Inject
    lateinit var producer: TestProducer

    @Get("/")
    @Produces(MediaType.TEXT_PLAIN)
    fun index(): String {
        println("GET /hello")

        producer!!.send("aKey", "Hello Kotlin world!")

        return "Hello Kotlin World!!"
    }
}
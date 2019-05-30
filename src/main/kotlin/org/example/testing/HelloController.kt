package org.example.t

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import javax.inject.Inject

@Controller("/hello")
class HelloController {

    @Inject
    lateinit var producer: TestProducer

    @Get(produces = arrayOf(MediaType.TEXT_PLAIN))
    fun index(): String {

        producer!!.send("aKey", "Hello Kotlin world!")

        return "Hello Kotlin World!!"
    }
}
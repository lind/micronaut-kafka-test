package org.example.t

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import org.example.kafka.TestProducer
import javax.inject.Inject

@Controller("/hello")
class HelloController {

    @Inject
    internal var producer: TestProducer? = null

    @Get(produces = arrayOf(MediaType.TEXT_PLAIN))
    fun index(): String {

        producer!!.send("aKey", "Hello Kotlin world!")

        return "Hello Kotlin World!!"
    }
}
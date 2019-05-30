package org.example.testing

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("/test")
class TestController {

    @Get("/")
    @Produces(MediaType.TEXT_PLAIN)
    fun get(): String {
        return "Hello world!!"
    }
}
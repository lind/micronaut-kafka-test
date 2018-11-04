package org.example.kafka;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;

@Controller("/hello")
public class HelloController {

    @Inject
    TestProducer producer;

    @Get(produces = MediaType.TEXT_PLAIN)
    public String index() {

        producer.send("aKey", "Hello world!");

        return "Hello World";
    }
}
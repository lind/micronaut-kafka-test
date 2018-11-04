package org.example.kafka;

import io.micronaut.configuration.kafka.config.AbstractKafkaConfiguration;
import io.micronaut.configuration.kafka.embedded.KafkaEmbedded;
import io.micronaut.context.ApplicationContext;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KafkaProducerListenerTest {

    static Map<String, Object> config;
    static KafkaEmbedded kafkaEmbedded;

    @BeforeAll
    public static void init() {

        config = Collections.
                unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put(AbstractKafkaConfiguration.EMBEDDED, true);
                        put(AbstractKafkaConfiguration.EMBEDDED_TOPICS, "test_topic");
                    }
                });
    }

    @Test
    public void testListener() {


        try (ApplicationContext ctx = ApplicationContext.run(config)) {
            Holder holder = ctx.getBean(Holder.class);

            System.out.println("Kafka up? " + (pingHost("localhost", 9092, 1000) ? "Yes Kafka is up" : "No!"));

            TestListener listener = ctx.getBean(TestListener.class);

            TestProducer producer = ctx.getBean(TestProducer.class);
            producer.send("key", "The value!!");

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            assertEquals("The value!!", holder.getMessage());
        }
    }

    public static boolean pingHost(String host, int port, int timeout) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), timeout);
            return true;
        } catch (IOException e) {
            return false; // Either timeout or unreachable or failed DNS lookup.
        }
    }
}
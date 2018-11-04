package org.example.kafka;

import javax.inject.Singleton;

@Singleton
public class Holder {
    private String message = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

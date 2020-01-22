package com.dhb.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch){
        this.latch = latch;
    }

    public void receiverMessage(String message){
        LOGGER.info("Received<" + message + ">");
        latch.countDown();
    }
}
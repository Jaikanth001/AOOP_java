package com.messageapplication;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Producer implements Runnable {
    private final BlockingQueue<String> buffer;
    private final int messageCount;

    public Producer(BlockingQueue<String> buffer, int messageCount) {
        this.buffer = buffer;
        this.messageCount = messageCount;
    }    

@Override
public void run() {
    try {
        for (int i = 1; i <= messageCount; i++) {
            String message = "Message " + i;
            buffer.put(message);  // Add message to the buffer
            System.out.println("Produced: " + message);
            Thread.sleep(100);  // Simulate time taken to produce a message
        }
        buffer.put("END");  // Indicate the end of messages
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
}
}
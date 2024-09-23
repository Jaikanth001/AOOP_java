package com.messageapplication;

import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable {
    private final BlockingQueue<String> buffer;

    public Consumer(BlockingQueue<String> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = buffer.take();  
                if ("END".equals(message)) {
                    break;  
                }
                System.out.println("Consumed: " + message);
                Thread.sleep(150);  
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

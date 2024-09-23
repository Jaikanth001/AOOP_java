package com.buffer;

class Consumer implements Runnable {
    private final com.buffer.BoundedBuffer buffer;

    public Consumer(com.buffer.BoundedBuffer buffer2) {
        this.buffer = buffer2;
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
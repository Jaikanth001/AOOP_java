package com.buffer;

class Producer implements Runnable {
    private final com.buffer.BoundedBuffer buffer;
    private final int messageCount;

    public Producer(com.buffer.BoundedBuffer buffer2, int messageCount) {
        this.buffer = buffer2;
        this.messageCount = messageCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= messageCount; i++) {
                String message = "Message " + i;
                buffer.put(message);  
                System.out.println("Produced: " + message);
                Thread.sleep(100);  
            }
            buffer.put("END"); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

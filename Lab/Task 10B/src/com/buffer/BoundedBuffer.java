package com.buffer;

class BoundedBuffer {
    private final String[] buffer;
    private int count, in, out;

    public BoundedBuffer(int capacity) {
        buffer = new String[capacity];
        count = in = out = 0;
    }

    public synchronized void put(String item) throws InterruptedException {
        while (count == buffer.length) {
            wait();  
        }
        buffer[in] = item;
        in = (in + 1) % buffer.length;
        count++;
        notifyAll(); 
    }

    public synchronized String take() throws InterruptedException {
        while (count == 0) {
            wait();  
        }
        String item = buffer[out];
        out = (out + 1) % buffer.length;
        count--;
        notifyAll();  
        return item;
    }
}

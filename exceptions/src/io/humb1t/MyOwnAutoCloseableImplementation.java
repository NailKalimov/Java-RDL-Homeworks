package io.humb1t;

public class MyOwnAutoCloseableImplementation implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("method close run");
    }
}

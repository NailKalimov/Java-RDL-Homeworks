package io.humb1t;

import io.humb1t.exceptions.IllegalNumberOfDoorException;
import io.humb1t.exceptions.LifeCycleExecutionMyOwnException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        try {
            new LifeCycleAction().execute();
        } catch (LifeCycleActionExecutionException | AccessDeniedException e) {
            System.err.println(e.getLocalizedMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  Task 2: Create your own implementation of java.lang.AutoCloseable interface. Test it.
        try (MyOwnAutoCloseableImplementation myOwnAutoCloseableImplementation = new MyOwnAutoCloseableImplementation()) {

        } catch (Exception e) {
            e.printStackTrace();
        }
        //  Task 3: Create a new class. Implement constructor which should throw an exception during execution.
        // Write a simple program where you attempt to instantiate object of this class and assign it to a variable
        // (declaration should be outside try/catch block). Catch an exception.
        Car car = null;
        try {
            car = new Car(0);
        } catch (IllegalNumberOfDoorException e) {
            System.out.println(e.getMessage());
        }

    }

    public static class LifeCycleAction {
        public void execute() throws LifeCycleActionExecutionException, AccessDeniedException, LifeCycleExecutionMyOwnException {
            throw new LifeCycleActionExecutionException();
        }
    }

    public static class LifeCycleActionExecutionException extends Exception {
    }


    public void exceptionVsResult() {
        final String result1 = (String) this.returnResult().value;
        final String result2 = returnOptional().orElse("");
        String result3 = "";
        try {
            result3 = returnValueOrThrowException();
        } catch (AccessDeniedException e) {
        }
    }

    private Result returnResult() {
        return Result.OK.setValue("OK");
    }

    private Optional<String> returnOptional() {
        return Optional.of("OK");
    }

    private String returnValueOrThrowException() throws AccessDeniedException {
        return "OK";
    }
}

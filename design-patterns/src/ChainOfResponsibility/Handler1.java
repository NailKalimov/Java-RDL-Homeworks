package ChainOfResponsibility;

import java.math.BigInteger;

public class Handler1 extends ABaseHandler {

    @Override
    public void setNextHandler(IHandler handler) {
        next = handler;
    }

    @Override
    public void handle(Request request) {
        if (validate(request)) {
            System.out.println("Handler1 handled " + request.value);
        } else if (next != null) {
            next.handle(request);
        }
    }

    @Override
    public boolean validate(Request request) {
        return new BigInteger(String.valueOf(request.value)).isProbablePrime(1);
    }
}

package ChainOfResponsibility;

public class Handler2 extends ABaseHandler {

    @Override
    public void setNextHandler(IHandler handler) {
        next = handler;
    }

    @Override
    public void handle(Request request) {
        if (validate(request)) {
            System.out.println("Handler2 handled " + request.value);
        } else if (next != null) {
            next.handle(request);
        }
    }

    @Override
    public boolean validate(Request request) {
        return request.value % 2 == 0;
    }
}

package ChainOfResponsibility;

public class Handler3 extends ABaseHandler {

    @Override
    public void setNextHandler(IHandler handler) {
        next = handler;
    }

    @Override
    public void handle(Request request) {
        if (validate(request)) {
            System.out.println("Handler3 handled " + request.value);
        } else if (next != null) {
            next.handle(request);
        }
    }

    @Override
    public boolean validate(Request request) {
        return request.value % 3 == 0;
    }
}

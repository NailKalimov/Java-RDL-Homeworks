package ChainOfResponsibility;

public class ErrorHandler extends ABaseHandler {

    @Override
    public void setNextHandler(IHandler handler) {
        next = handler;
    }

    @Override
    public void handle(Request request) {
        System.out.println(request.value + " not handled");
    }

    @Override
    public boolean validate(Request request) {
        return true;
    }
}

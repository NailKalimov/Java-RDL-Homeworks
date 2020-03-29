package Builder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BusinessEmailBuilder builder = new BusinessEmailBuilder();
        builder.reset();
        builder.setRecipients();
        builder.setSubject();
        builder.setText();
        EmailMessage message = builder.getMessage();
        System.out.println("Результат: " + message);
    }
}

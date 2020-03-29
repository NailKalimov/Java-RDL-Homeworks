package Builder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BusinessEmailBuilder implements IBuilder {
    public static final String SENDER_EMAIL_ADDRESS = "nailkalimov@gmail.com";
    public static final String PHONE_NUMBER = "89632145789";
    static Recipient sender = new Recipient(System.getProperty("user.name"), SENDER_EMAIL_ADDRESS);
    BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

    EmailMessage message;

    @Override
    public void reset() {
        message = new EmailMessage();
    }

    @Override
    public void setRecipients() throws IOException {
        String recipientName;
        String recipientAddress;
        String flag = "+";
        List<IRecipient> recipients = new ArrayList<>();
        while (flag.equals("+")) {
            System.out.print("Введите ФИО получателя: ");
            recipientName = scanner.readLine();
            System.out.print("Введите email получателя: ");
            recipientAddress = scanner.readLine();
            recipients.add(new Recipient(recipientName, recipientAddress));
            System.out.println("Если хотите добавить ещё получателя, введите \"+\" ");
            flag = scanner.readLine();
        }
        message.create(sender, recipients);
    }

    @Override
    public void setSubject() throws IOException {
        System.out.print("Введите тему письма:");
        message.Subject = scanner.readLine();
    }

    @Override
    public void setText() throws IOException {
        StringBuilder text = new StringBuilder();
        System.out.println("Ввдеите текст письма: ");
        text.append(scanner.readLine());
        text.append(" С уважением, " + System.getProperty("user.name") + "." + "Тел: " + PHONE_NUMBER + ".");
        message.body = text.toString();
    }

    EmailMessage getMessage() throws IOException {
        scanner.close();
        return message;
    }
}

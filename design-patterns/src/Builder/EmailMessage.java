package Builder;

import java.util.List;

public class EmailMessage implements IEmailMessage {
    List<IRecipient> Recipients; // получатели
    IRecipient Sender; // отправитель
    String body; // текст письма
    String Subject; // тема письма

    @Override
    public void send() {
    }

    @Override
    public IEmailMessage receive() {
        return null;
    }

    @Override
    public IEmailMessage create(IRecipient sender, List<IRecipient> recipient) {
        this.Recipients = recipient;
        this.Sender = sender;
        return this;
    }

    @Override
    public String toString() {
        return "Recipients: " + Recipients.toString() + ";" +
                " Sender[" + Sender.toString() + "];" +
                " Subject: " + Subject + ";" +
                " Text: " + body;
    }
}

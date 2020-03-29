package Builder;

public interface IRecipient {
    IRecipient create(String username, String address); // создать отправителя или получателя
}

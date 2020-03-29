package Builder;

public class Recipient implements IRecipient {
    String Username; // ФИО
    String Address; // адрес

    public Recipient(String username, String address) {
        Username = username;
        Address = address;
    }

    @Override
    public IRecipient create(String username, String address) {
        this.Username = username;
        this.Address = address;
        return this;
    }

    @Override
    public String toString() {
        return "Username: " + Username +
                " Address: " + Address;
    }
}

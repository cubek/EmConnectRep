package sk.fejero.emconnect.account;

/**
 * Created by fejero on 12.11.2014.
 */
public class Account {

    private String address;
    private AccountType type;

    public Account(String address, AccountType type){
        this.address = address;
        this.type = type;
    }

    public AccountType getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }
}

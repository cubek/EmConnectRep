package sk.fejero.emconnect.management;

import java.util.Date;

import sk.fejero.emconnect.account.Account;
import sk.fejero.emconnect.account.AccountType;

import sk.fejero.emconnect.mailclient.EmailMessage;


/**
 * Created by fejero on 6.11.2014.
 */
public class DataLoader {
    private ContainerManagement cm;

    public void loadAccounts(ContainerManagement cm){
        cm.getAccountList().clear();
        Account account;

        account = new Account("vladimir.fejercak@gmail.com", AccountType.GMAIL);
        cm.addAccount(account);

        account = new Account("vladimir.fejercak@student.tuke.sk",AccountType.TUKE);
        cm.addAccount(account);
    }

    public void loadInbox(ContainerManagement cm){
        cm.getInboxMessageList().clear();

        EmailMessage im = new EmailMessage();
        im.setSent(new Date());
        im.setTo("fejero@fejero.com");
        im.setSubject("Inbox");
        im.setContent("Hello, I would like to bla bla bla...");
        cm.addInboxMessage(im);

        im = new EmailMessage();
        im.setSent(new Date());
        im.setTo("duri@fejero.com");
        im.setSubject("Penezi");
        im.setContent("Hello, I would like to bla bla bla...");
        cm.addInboxMessage(im);

        im = new EmailMessage();
        im.setSent(new Date());
        im.setTo("feri@fejero.com");
        im.setSubject("Zasilka");
        im.setContent("Hello, I would like to bla bla bla...");
        cm.addInboxMessage(im);

        im = new EmailMessage();
        im.setSent(new Date());
        im.setTo("jany@fejero.com");
        im.setSubject("Onee");
        im.setContent("Hello, I would like to bla bla bla...");
        cm.addInboxMessage(im);

        im = new EmailMessage();
        im.setSent(new Date());
        im.setTo("karci@fejero.com");
        im.setSubject("Neviem");
        im.setContent("Hello, I would like to bla bla bla...");
        cm.addInboxMessage(im);

    }

    public void loadSpam(ContainerManagement cm){
        cm.getSpamMessageList().clear();

        EmailMessage im = new EmailMessage();
        im.setSent(new Date());
        im.setTo("fejero@fejero.com");
        im.setSubject("Inbox");
        im.setContent("Hello, I would like to bla bla bla...");
        cm.addInboxMessage(im);

        im = new EmailMessage();
        im.setSent(new Date());
        im.setTo("lajci@fejero.com");
        im.setSubject("Spam");
        im.setContent("Hello, I would like to bla bla bla...");
        cm.addInboxMessage(im);

        im = new EmailMessage();
        im.setSent(new Date());
        im.setTo("duri@fejero.com");
        im.setSubject("Sorry");
        im.setContent("Hello, I would like to bla bla bla...");
        cm.addInboxMessage(im);

        im = new EmailMessage();
        im.setSent(new Date());
        im.setTo("feri@fejero.com");
        im.setSubject("Omyl");
        im.setContent("Hello, I would like to bla bla bla...");
        cm.addInboxMessage(im);

        im = new EmailMessage();
        im.setSent(new Date());
        im.setTo("muri@fejero.com");
        im.setSubject("Hups");
        im.setContent("Hello, I would like to bla bla bla...");
        cm.addInboxMessage(im);

        im = new EmailMessage();
        im.setSent(new Date());
        im.setTo("pista@fejero.com");
        im.setSubject("Pardon");
        im.setContent("Hello, I would like to bla bla bla...");
        cm.addInboxMessage(im);
    }

    public void loadTrash(ContainerManagement cm){
        EmailMessage im = new EmailMessage();
        im.setSent(new Date());
        im.setTo("fejero@fejero.com");
        im.setSubject("Inbox");
        im.setContent("Hello, I would like to bla bla bla...");
        cm.addInboxMessage(im);

        im = new EmailMessage();
        im.setSent(new Date());
        im.setTo("lajci@fejero.com");
        im.setSubject("Spam");
        im.setContent("Hello, I would like to bla bla bla...");
        cm.addInboxMessage(im);

        im = new EmailMessage();
        im.setSent(new Date());
        im.setTo("duri@fejero.com");
        im.setSubject("Sorry");
        im.setContent("Hello, I would like to bla bla bla...");
        cm.addInboxMessage(im);

    }

    public void loadSent(ContainerManagement cm){
        /*cm.getSentMessageList().clear();
        for (int i = 0; i < 1; i++) {
            SentMessage im = new SentMessage(new Date(), "fejero@fejero.com", "Sent", "", "Hello, I would like to bla bla bla...");
            cm.addSentMessage(im);
        }*/
    }

    public void loadConcepts(ContainerManagement cm){
        /*cm.getConceptMessageList().clear();
        for (int i = 0; i < 1; i++) {
            ConceptMessage im = new ConceptMessage(new Date(), "fejero@fejero.com", "Concept", "", "Hello, I would like to bla bla bla...");
            cm.addConceptMessage(im);
        }*/
    }


    public Account loadCurrentAccount(ContainerManagement cm) {
        return cm.getAccountList().get(0);
    }
}

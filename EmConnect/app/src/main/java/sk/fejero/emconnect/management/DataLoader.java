package sk.fejero.emconnect.management;

import java.util.Date;

import sk.fejero.emconnect.account.Account;
import sk.fejero.emconnect.account.AccountType;

import sk.fejero.emconnect.messages.Message;


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

        Message im = new Message(new Date(), "fejero@fejero.com", "Inbox", "", "Hello, I would like to bla bla bla...");
        cm.addInboxMessage(im);

        im = new Message(new Date(), "duri@fejero.com", "Penezi", "", "Hello, I would like to bla bla bla...");
        cm.addInboxMessage(im);

        im = new Message(new Date(), "feri@fejero.com", "Zasilka", "", "Hello, I would like to bla bla bla...");
        cm.addInboxMessage(im);

        im = new Message(new Date(), "jany@fejero.com", "Onee", "", "Hello, I would like to bla bla bla...");
        cm.addInboxMessage(im);

        im = new Message(new Date(), "karci@fejero.com", "Neviem", "", "Hello, I would like to bla bla bla...");
        cm.addInboxMessage(im);

    }

    public void loadSpam(ContainerManagement cm){
        cm.getSpamMessageList().clear();

        Message im = new Message(new Date(), "fejero@fejero.com", "Inbox", "", "Hello, I would like to bla bla bla...");
        cm.addSpamMessage(im);

        im = new Message(new Date(), "karci@fejero.com", "Inbox", "", "Hello, I would like to bla bla bla...");
        cm.addSpamMessage(im);

        im = new Message(new Date(), "lajci@fejero.com", "Spam", "", "Hello, I would like to bla bla ...");
        cm.addSpamMessage(im);

        im = new Message(new Date(), "duri@fejero.com", "Sorry", "", "Hello, I would like to bla ...");
        cm.addSpamMessage(im);

        im = new Message(new Date(), "feri@fejero.com", "Omyl", "", "Hello, I would like to ...");
        cm.addSpamMessage(im);

        im = new Message(new Date(), "muri@fejero.com", "Hups", "", "Hello, I would like ...");
        cm.addSpamMessage(im);

        im = new Message(new Date(), "pista@fejero.com", "Pardon", "", "Hello, I would...");
        cm.addSpamMessage(im);
    }

    public void loadTrash(ContainerManagement cm){
        cm.getTrashMessageList().clear();

            Message im = new Message(new Date(), "fejero@fejero.com", "Trash", "", "Hello, I would like to bla bla bla...");
            cm.addTrashMessage(im);

        im = new Message(new Date(), "duri@fejero.com", "Trash", "", "Hello, I would like to bla bla bla...");
        cm.addTrashMessage(im);

        im = new Message(new Date(), "feri@fejero.com", "Trash", "", "Hello, I would like to bla bla bla...");
        cm.addTrashMessage(im);

        im = new Message(new Date(), "miro@fejero.com", "Trash", "", "Hello, I would like to bla bla bla...");
        cm.addTrashMessage(im);

        im = new Message(new Date(), "jano@fejero.com", "Trash", "", "Hello, I would like to bla bla bla...");
        cm.addTrashMessage(im);

        im = new Message(new Date(), "fizli@fejero.com", "Trash", "", "Hello, I would like to bla bla bla...");
        cm.addTrashMessage(im);

        im = new Message(new Date(), "blabla@fejero.com", "Trash", "", "Hello, I would like to bla bla bla...");
        cm.addTrashMessage(im);

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

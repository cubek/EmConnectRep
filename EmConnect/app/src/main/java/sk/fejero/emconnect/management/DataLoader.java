package sk.fejero.emconnect.management;

import android.util.Log;

import java.util.Date;

import sk.fejero.emconnect.messages.ConceptMessage;
import sk.fejero.emconnect.messages.InboxMessage;
import sk.fejero.emconnect.messages.SentMessage;
import sk.fejero.emconnect.messages.SpamMessage;
import sk.fejero.emconnect.messages.TrashMessage;

/**
 * Created by fejero on 6.11.2014.
 */
public class DataLoader {
    private ContainerManagement cm;



    public void loadData(){
        Log.i("Loading", "Loading data");
    }

    public void loadInbox(ContainerManagement cm){
        cm.getInboxMessageList().clear();
        for (int i = 0; i < 5; i++) {
            InboxMessage im = new InboxMessage(new Date(), "fejero@fejero.com", "Inbox", "", "Hello, I would like to bla bla bla...");
            cm.addInboxMessage(im);
        }
    }

    public void loadSpam(ContainerManagement cm){
        cm.getSpamMessageList().clear();
        for (int i = 0; i < 6; i++) {
            SpamMessage im = new SpamMessage(new Date(), "fejero@fejero.com", "Spam", "", "Hello, I would like to bla bla bla...");
            cm.addSpamMessage(im);
        }
    }

    public void loadTrash(ContainerManagement cm){
        cm.getTrashMessageList().clear();
        for (int i = 0; i < 7; i++) {
            TrashMessage im = new TrashMessage(new Date(), "fejero@fejero.com", "Trash", "", "Hello, I would like to bla bla bla...");
            cm.addTrashMessage(im);
        }
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


}

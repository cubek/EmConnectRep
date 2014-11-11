package sk.fejero.emconnect.management;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sk.fejero.emconnect.messages.ConceptMessage;
import sk.fejero.emconnect.messages.InboxMessage;
import sk.fejero.emconnect.messages.SentMessage;
import sk.fejero.emconnect.messages.SpamMessage;
import sk.fejero.emconnect.messages.TrashMessage;

/**
 * Created by fejero on 5.11.2014.
 */
public class ContainerManagement {

    private List<InboxMessage> inboxMessageList = new ArrayList<InboxMessage>();
    private List<SentMessage> sentMessageList = new ArrayList<SentMessage>();
    private List<TrashMessage> trashMessageList = new ArrayList<TrashMessage>();
    private List<SpamMessage> spamMessageList = new ArrayList<SpamMessage>();
    private List<ConceptMessage> conceptMessageList = new ArrayList<ConceptMessage>();


    public void addTrashMessage(TrashMessage trashMessage){
        trashMessageList.add(trashMessage);
    }

    public boolean removeTrashInboxMessage(int i){
        if(i<trashMessageList.size()) {
            trashMessageList.remove(i);
            return true;
        }
        else{
            return false;
        }

    }

    public void addSpamMessage(SpamMessage spamMessage){
        spamMessageList.add(spamMessage);
    }

    public boolean removeSpamMessage(int i){
        if(i<spamMessageList.size()) {
            spamMessageList.remove(i);
            return true;
        }
        else{
            return false;
        }
    }

    public void addConceptMessage(ConceptMessage conceptmessage){
        conceptMessageList.add(conceptmessage);
    }

    public boolean removeConceptMessage(int i){
        if(i<conceptMessageList.size()) {
            conceptMessageList.remove(i);
            return true;
        }
        else{
            return false;
        }
    }

    public void addInboxMessage(InboxMessage inboxMessage){
        inboxMessageList.add(inboxMessage);
    }

    public boolean removeInboxMessage(int i){
        if(i<inboxMessageList.size()) {
            inboxMessageList.remove(i);
            return true;
        }
        else{
            return false;
        }

    }

    public void addSentMessage(SentMessage sentMessage){
        sentMessageList.add(sentMessage);
    }

    public boolean removeSentMessage(int i){
        if(i<sentMessageList.size()) {
            sentMessageList.remove(i);
            return true;
        }
        else{
            return false;
        }

    }

    public List<InboxMessage> getInboxMessageList() {
        return inboxMessageList;
    }

    public List<SentMessage> getSentMessageList() {
        return sentMessageList;
    }

    public List<TrashMessage> getTrashMessageList() {
        return trashMessageList;
    }

    public List<ConceptMessage> getConceptMessageList() {
        return conceptMessageList;
    }

    public List<SpamMessage> getSpamMessageList() {
        return spamMessageList;
    }


}

package sk.fejero.emconnect.management;

import java.util.ArrayList;
import java.util.List;

import sk.fejero.emconnect.account.Account;

import sk.fejero.emconnect.messages.Message;


/**
 * Created by fejero on 5.11.2014.
 */
public class ContainerManagement {

    private List<Message> inboxMessageList = new ArrayList<Message>();
    private List<Message> sentMessageList = new ArrayList<Message>();
    private List<Message> trashMessageList = new ArrayList<Message>();
    private List<Message> spamMessageList = new ArrayList<Message>();
    private List<Message> conceptMessageList = new ArrayList<Message>();
    private List<Account> accountList = new ArrayList<Account>();
    private Account currentAccount;
    private Message tempMessage=null;



    public void setTempMessage(Message message){

        this.tempMessage = message;
        //Log.i("Set temp", tempMessage.getAddress());
    }

    public Message getTempMessage(){
        //Log.i("Get temp", tempMessage.getAddress());
        return tempMessage;
    }





    public void addTrashMessage(Message trashMessage){
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

    public void addSpamMessage(Message spamMessage){
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

    public void addConceptMessage(Message conceptmessage){
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

    public void addInboxMessage(Message inboxMessage){
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

    public void addSentMessage(Message sentMessage){
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

    public void addAccount(Account account){
        accountList.add(account);
    }

    public boolean removeAccount(Account a){
        return accountList.remove(a);

    }

    public List<Message> getInboxMessageList() {
        return inboxMessageList;
    }

    public List<Message> getSentMessageList() {
        return sentMessageList;
    }

    public List<Message> getTrashMessageList() {
        return trashMessageList;
    }

    public List<Message> getConceptMessageList() {
        return conceptMessageList;
    }

    public List<Message> getSpamMessageList() {
        return spamMessageList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }


}

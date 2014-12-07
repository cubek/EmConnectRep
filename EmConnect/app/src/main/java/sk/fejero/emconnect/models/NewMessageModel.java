package sk.fejero.emconnect.models;

import sk.fejero.emconnect.management.ContainerManagement;
import sk.fejero.emconnect.messages.Message;

/**
 * Created by fejero on 11.11.2014.
 */
public class NewMessageModel {

    private ContainerManagement cm;
    public NewMessageModel(ContainerManagement cm){
        this.cm = cm;
    }

    public void sendEmail(Message m){
        cm.addSentMessage(m);
    }


    public void loadAttachement() {
    }

    public void saveEmailToConcepts(Message m) {
        cm.addConceptMessage(m);
    }
}

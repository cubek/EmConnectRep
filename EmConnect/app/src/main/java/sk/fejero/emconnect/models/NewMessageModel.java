package sk.fejero.emconnect.models;

import android.util.Log;

import java.util.Date;

import sk.fejero.emconnect.management.ContainerManagement;
import sk.fejero.emconnect.messages.ConceptMessage;
import sk.fejero.emconnect.messages.Message;
import sk.fejero.emconnect.messages.SentMessage;

/**
 * Created by fejero on 11.11.2014.
 */
public class NewMessageModel {

    private ContainerManagement cm;
    public NewMessageModel(ContainerManagement cm){
        this.cm = cm;
    }

    public void sendEmail(SentMessage m){
        cm.addSentMessage(m);
    }


    public void loadAttachement() {
    }

    public void saveEmailToConcepts(ConceptMessage m) {
        cm.addConceptMessage(m);
    }
}

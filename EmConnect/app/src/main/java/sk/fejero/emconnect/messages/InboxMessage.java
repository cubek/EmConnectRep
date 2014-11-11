package sk.fejero.emconnect.messages;

import java.util.Date;

/**
 * Created by fejero on 5.11.2014.
 */
public class InboxMessage extends Message {

    public InboxMessage(Date date, String address, String subject, String cc, String content){
        super(date, address, subject, cc, content);
    }



}

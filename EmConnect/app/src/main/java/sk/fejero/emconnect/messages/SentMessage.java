package sk.fejero.emconnect.messages;

import java.util.Date;

import sk.fejero.emconnect.messages.Message;

/**
 * Created by fejero on 5.11.2014.
 */
public class SentMessage extends Message {

    public SentMessage(Date date, String address, String subject, String cc, String content) {
        super(date, address, subject, cc, content);
    }
}

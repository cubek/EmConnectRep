package sk.fejero.emconnect.messages;

import android.text.format.Time;

import java.util.Date;

/**
 * Created by fejero on 6.11.2014.
 */
public class Message {

    private Date date;
    private String subject;
    private String address;
    private String cc;
    private String content;

    public Message(Date date,String address, String subject, String cc, String content){
        this.date = date;
        this.address = address;
        this.cc = cc;
        this.content = content;
        this.subject = subject;
    }

    public String getAddress() {
        return address;
    }

    public String getCc() {
        return cc;
    }

    public String getContent() {
        return content;
    }

    public String getSubject() {
        return subject;
    }

    public Date getDate() {
        return date;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.fejero.emconnect.mailclient;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import sk.fejero.emconnect.mailclient.incomming.ImapClient;
import sk.fejero.emconnect.mailclient.outcomming.SmtpClient;


/**
 *
 * @author Rastislav
 */
public class MailClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final AccountSettings acc = new AccountSettings("rc301ve", "3PpgN9X8");
        acc.setImapPort(993);
        acc.setImapServer("posta.tuke.sk");
        acc.setSmtpPort(465);
        acc.setSmtpServer("smtp.tuke.sk");
        acc.setStoreMails(1209600);
        acc.setDwnFolder("t:\\mail_attachements\\");
        
        String author  = "rastislav.cubo@student.tuke.sk";
        String recipient  = "rastislav.cubo@gmail.com";

        //Logger.getGlobal().log(Level.INFO, "Creating SMTP client");
        /*
        SmtpClient client = new SmtpClient(acc);
        EmailMessage mes = new EmailMessage();
        mes.setAuthor(author);
        mes.setTo(recipient);
        mes.setCc("");
        mes.setSubject("library test");
        mes.setSent(new Date());
        mes.setContent("Test... Test... Test... \nNew line test");
        String[] att = new String[2];
        att[0] = "t:\\deadpool.jpg";
        att[1] = "t:\\CIT.ppt";
        mes.setAttachements(att);
        
        try {
            client.sendMessage(mes);
        } catch (MessagingException ex) {
            Logger.getLogger(MailClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        ImapClient imapClient = new ImapClient(acc);
        try {
            String[] folders = imapClient.getFoldersNames();
            System.out.println("Got "+folders.length+" folders");
            for(String folder: folders) {
                System.out.println("Found folder: " +folder);
            }
            EmailMessage[] messages = imapClient.getMessages("INBOX");
            for (EmailMessage message : messages) {
                System.out.println("Folder: "+message.getFolder());
                System.out.println("From: "+message.getAuthor()+"\nTo: "+message.getTo());
                System.out.println("Content: \n"+message.getContent());
            }
        } catch (MessagingException  ex) {
            Logger.getLogger(MailClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {

            Logger.getLogger(MailClient.class.getName()).log(Level.SEVERE, null, e);
        }

    }
    
}

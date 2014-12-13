package sk.fejero.emconnect.management;

import sk.fejero.emconnect.mailclient.AccountSettings;

/**
 * Created by fejero on 13.12.2014.
 */
public class AccountSettingsBundle {

    private String name;
    private String pass;
    private String imapServer;
    private String imapPort;
    private String smtpServer;
    private String smtpPort;
    private String backUpDuration;


    public AccountSettingsBundle(String name, String pass, String imapServer, String imapPort, String smtpServer, String smtpPort, String backUpDuration){
        this.name = name;
        this.pass = pass;
        this.imapServer = imapServer;
        this.imapPort = imapPort;
        this.smtpPort = smtpPort;
        this.smtpServer = smtpServer;
        this.backUpDuration = backUpDuration;
    }

    public String getBackUpDuration() {
        return backUpDuration;
    }

    public String getImapPort() {
        return imapPort;
    }

    public String getImapServer() {
        return imapServer;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public String getSmtpPort() {
        return smtpPort;
    }

    public String getSmtpServer() {
        return smtpServer;
    }
}

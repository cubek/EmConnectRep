package sk.fejero.emconnect.asynctasks;

import android.os.AsyncTask;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.mail.Message;
import javax.mail.MessagingException;
import sk.fejero.emconnect.mailclient.EmailMessage;
import sk.fejero.emconnect.mailclient.incomming.ImapClient;
import sk.fejero.emconnect.management.ContainerManagement;

/**
 * Created by Rastislav on 10.12.2014.
 */
public class EmailDownloaderTask extends AsyncTask<String, EmailMessage, String> {

    private ContainerManagement cm;
    private ImapClient imap;
    private String folder;

    public EmailDownloaderTask(ContainerManagement cm, ImapClient imap, String folder){
        this.cm = cm;
        this.imap = imap;
        this.folder = folder;
    }

    @Override
    protected String doInBackground(String... folders) {
        Message[] msgs;
        EmailMessage email;
        for(String folder: folders) {
            try {
                imap.openFolder(folder);
                msgs = imap.getMessages();
                for(Message msg : msgs) {
                    email = imap.getMessage(msg);
                    publishProgress(email);
                }
                imap.closeFolder();
            } catch (MessagingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "executed";
    }

    @Override
    protected void onProgressUpdate(EmailMessage... msg) {
        /*Log.i("Email info", "Msg  from:" + msg[0].getAuthor());
        Log.i("Email info", "Msg  date:" + msg[0].getSent());
        Log.i("Email info", "Msg  body:" + msg[0].getContent().substring(0,100));
        Log.i("Email info", "Msg files:" + Arrays.toString(msg[0].getAttachments()));*/
        Log.i("Email info", "Msg received");
        if(msg[0].getFolder().equalsIgnoreCase("inbox")) {
            cm.addInboxMessage(msg[0]);
        }
        if(msg[0].getFolder().equalsIgnoreCase("sent")) {
            cm.addSentMessage(msg[0]);
        }
        if(msg[0].getFolder().equalsIgnoreCase("spam")) {
            cm.addSpamMessage(msg[0]);
        }
        if(msg[0].getFolder().equalsIgnoreCase("trash")) {
            cm.addTrashMessage(msg[0]);
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String a) {
        super.onPostExecute(a);
        try {
            File file = new File(folder+"inbox.emcc");
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fileOut);
            oos.writeObject(cm.getInboxMessageList());
            Log.i("File info", "File name :" + file.getAbsolutePath());

            file = new File(folder+"sent.emcc");
            fileOut = new FileOutputStream(file);
            oos = new ObjectOutputStream(fileOut);
            oos.writeObject(cm.getSentMessageList());
            Log.i("File info", "File name :" + file.getAbsolutePath());

            file = new File(folder+"trash.emcc");
            fileOut = new FileOutputStream(file);
            oos = new ObjectOutputStream(fileOut);
            oos.writeObject(cm.getTrashMessageList());
            Log.i("File info", "File name :" + file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

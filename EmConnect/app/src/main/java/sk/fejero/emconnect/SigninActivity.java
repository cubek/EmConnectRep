package sk.fejero.emconnect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.security.NoSuchProviderException;

import javax.mail.MessagingException;

import sk.fejero.emconnect.mailclient.AccountSettings;
import sk.fejero.emconnect.mailclient.incomming.ImapClient;
import sk.fejero.emconnect.mailclient.outcomming.SmtpClient;


public class SigninActivity extends Activity {

    private Button loginButton;
    private EditText userEditText;
    private EditText passEditText;
    private EditText imapEditText;
    private EditText smtpEditText;
    private EditText imapPortEditText;
    private EditText smtpPortEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        //setContentView(R.layout.activity_signin);



        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            //your codes here

        }

        userEditText = (EditText)findViewById(R.id.username_text);
        userEditText.setText("rc301ve");
        passEditText = (EditText)findViewById(R.id.pass_text);
        imapEditText = (EditText)findViewById(R.id.imap_text);
        imapEditText.setText("posta.tuke.sk");
        smtpEditText = (EditText)findViewById(R.id.smtp_text);
        smtpEditText.setText("smtp.tuke.sk");
        imapPortEditText = (EditText)findViewById(R.id.imap_port);
        imapPortEditText.setText("993");
        smtpPortEditText = (EditText)findViewById(R.id.smtp_port);
        smtpPortEditText.setText("465");

        loginButton = (Button)findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean verified = false;
                String user = userEditText.getText().toString();
                String pwd = passEditText.getText().toString();

                String imapServer = imapEditText.getText().toString();
                String imapPort = imapPortEditText.getText().toString();
                String smtpServer = smtpEditText.getText().toString();
                String smtpPort = smtpPortEditText.getText().toString();


                AccountSettings acc = new AccountSettings(user,pwd);
                if(!imapPort.isEmpty()){
                    acc.setImapPort(Integer.parseInt(imapPort));
                }

                if(!smtpPort.isEmpty()){
                    acc.setSmtpPort(Integer.parseInt(smtpPort));
                }

                acc.setImapServer(imapServer);
                acc.setSmtpServer(smtpServer);

                ImapClient imapclient = new ImapClient(acc);

                try {
                    imapclient.testConnection();
                    verified = true;
                } catch (javax.mail.NoSuchProviderException e ) {
                    e.printStackTrace();
                    Context context = getApplicationContext();
                    CharSequence text = "J.B.M.N.T!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } catch (MessagingException e) {
                    e.printStackTrace();
                    Context context = getApplicationContext();
                    CharSequence text = "Wrong Credentials Bro!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }


                if (verified) {
                    Intent myIntent = new Intent(SigninActivity.this,
                            EmailActivity.class);


                    myIntent.putExtra("userName",acc.getUserName());
                    myIntent.putExtra("userPwd",acc.getUserPwd());
                    myIntent.putExtra("smtpServer",acc.getSmtpServer());
                    myIntent.putExtra("imapServer",acc.getImapServer());
                    myIntent.putExtra("dwnFolder","mailclient");
                    myIntent.putExtra("smtpPort",acc.getSmtpPort());
                    myIntent.putExtra("imapPort",acc.getImapPort());
                    myIntent.putExtra("storeMails",1209600);

                    startActivity(myIntent);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.signin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

package sk.fejero.emconnect;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import javax.mail.MessagingException;

import sk.fejero.emconnect.fragments.CurrentFragment;
import sk.fejero.emconnect.mailclient.AccountSettings;
import sk.fejero.emconnect.mailclient.incomming.ImapClient;
import sk.fejero.emconnect.mailclient.outcomming.SmtpClient;
import sk.fejero.emconnect.management.ContainerManagement;
import sk.fejero.emconnect.management.DataLoader;
import sk.fejero.emconnect.models.NewMessageModel;

public class EmailActivity extends FragmentActivity implements ActionBar.TabListener {


    private SectionPagerAdapter mAppSectionsPagerAdapter;
    private ContainerManagement containerManagement;
    private DataLoader loader;
    private ViewPager mViewPager;
    private NewMessageModel newMessageModel;
    private int cf;
    private AccountSettings acc;
    private ImapClient imapClient;
    private SmtpClient smtpClient;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        containerManagement = new ContainerManagement();
        loader = new DataLoader();
        newMessageModel = new NewMessageModel(containerManagement);

        Intent intent = getIntent();
        Log.i("Intent data",intent.getStringExtra("userName"));

        acc = new AccountSettings(intent.getStringExtra("userName"),intent.getStringExtra("userPwd"));
        acc.setSmtpServer(intent.getStringExtra("smtpServer"));
        acc.setImapServer(intent.getStringExtra("imapServer"));
        acc.setImapPort(intent.getIntExtra("imapPort", -1));
        acc.setSmtpPort(intent.getIntExtra("smtpPort", -1));
        acc.setDwnFolder(intent.getStringExtra("dwnFolder"));
        acc.setStoreMails(intent.getIntExtra("storeMails", -1));

        imapClient = new ImapClient(acc);
        smtpClient = new SmtpClient(acc);
        try {
            imapClient.initStore();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        acc.setAuthor(imapClient.getAuthor());

        mAppSectionsPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager(),loader,containerManagement,newMessageModel, smtpClient);
        final ActionBar actionBar = getActionBar();
        actionBar.setHomeButtonEnabled(false);

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAppSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });
        mAppSectionsPagerAdapter.loadPagerView(mViewPager);


        for (int i = 0; i < mAppSectionsPagerAdapter.getCount(); i++) {
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mAppSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }



    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in the ViewPager.

        mViewPager.setCurrentItem(tab.getPosition());
        cf = tab.getPosition();
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.email_activity_action, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_refresh){

            switch(cf){
                case 0:
                    loader.loadInbox(containerManagement);
                    loader.loadSpam(containerManagement);
                    loader.loadTrash(containerManagement);
                    break;
                case 1:
                    loader.loadSent(containerManagement);
                    loader.loadConcepts(containerManagement);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            imapClient.closeStore();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}

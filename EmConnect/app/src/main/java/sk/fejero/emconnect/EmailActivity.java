package sk.fejero.emconnect;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;


import sk.fejero.emconnect.fragments.InboxSectionFragment;
import sk.fejero.emconnect.fragments.NewMessageSectionFragment;
import sk.fejero.emconnect.fragments.SentSectionFragment;
import sk.fejero.emconnect.fragments.SettingsSectionFragment;
import sk.fejero.emconnect.management.ContainerManagement;
import sk.fejero.emconnect.management.DataLoader;
import sk.fejero.emconnect.models.NewMessageModel;

public class EmailActivity extends FragmentActivity implements ActionBar.TabListener {


    private SectionPagerAdapter mAppSectionsPagerAdapter;
    private ContainerManagement containerManagement;
    private DataLoader loader;
    private ViewPager mViewPager;
    private NewMessageModel newMessageModel;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        containerManagement = new ContainerManagement();
        loader = new DataLoader();
        newMessageModel = new NewMessageModel(containerManagement);

        mAppSectionsPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager(),loader,containerManagement,newMessageModel);
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
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);


    }
}

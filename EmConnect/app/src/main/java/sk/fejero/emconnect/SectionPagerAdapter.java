package sk.fejero.emconnect;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import sk.fejero.emconnect.fragments.InboxSectionFragment;
import sk.fejero.emconnect.fragments.NewMessageSectionFragment;
import sk.fejero.emconnect.fragments.SentSectionFragment;
import sk.fejero.emconnect.fragments.SettingsSectionFragment;
import sk.fejero.emconnect.management.ContainerManagement;
import sk.fejero.emconnect.management.DataLoader;
import sk.fejero.emconnect.models.NewMessageModel;

/**
 * Created by fejero on 23.10.2014.
 */
public class SectionPagerAdapter extends FragmentPagerAdapter {

    private DataLoader loader;
    private ContainerManagement cm;
    private NewMessageModel newMessageModel;

    public SectionPagerAdapter(FragmentManager fm, DataLoader loader,ContainerManagement cm, NewMessageModel newMessageModel) {
        super(fm);
        this.newMessageModel = newMessageModel;
        this.loader = loader;
        this.cm = cm;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                InboxSectionFragment fragment = new InboxSectionFragment();
                fragment.loadLoader(loader,cm);
                return fragment;

            case 1:
                SentSectionFragment sentFragment = new SentSectionFragment();
                sentFragment.loadLoader(loader,cm);
                return sentFragment;
            case 2:
                NewMessageSectionFragment newMessagefragment = new NewMessageSectionFragment();
                newMessagefragment.loadModel(newMessageModel);
                return newMessagefragment;
            case 3:
                return new SettingsSectionFragment();
            default:
                return new NewMessageSectionFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Inbox";
            case 1:
                return "Sent";
            case 2:
                return "New Message";
            case 3:
                return "Settings";
            default: return "Inbox";
        }
    }
}

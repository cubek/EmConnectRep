package sk.fejero.emconnect;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import sk.fejero.emconnect.fragments.InboxSectionFragment;
import sk.fejero.emconnect.fragments.NewMessageSectionFragment;
import sk.fejero.emconnect.fragments.SentSectionFragment;
import sk.fejero.emconnect.fragments.SettingsSectionFragment;

/**
 * Created by fejero on 23.10.2014.
 */
public class SectionPagerAdapter extends FragmentPagerAdapter {

    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new InboxSectionFragment();

            case 1:
                return new SentSectionFragment();
            case 2:
                return new NewMessageSectionFragment();
            case 3:
                return new SettingsSectionFragment();
            default:
                return new InboxSectionFragment();
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

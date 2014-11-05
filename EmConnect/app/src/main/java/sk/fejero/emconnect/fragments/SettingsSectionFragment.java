package sk.fejero.emconnect.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import sk.fejero.emconnect.R;

/**
 * Created by fejero on 23.10.2014.
 */
public class SettingsSectionFragment extends Fragment{

    View view;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);


        final LinearLayout parentLayout = (LinearLayout)rootView.findViewById(R.id.settings_list_layout);

        view = inflater.inflate(R.layout.single_setting_layout, parentLayout, false);
        LinearLayout linkLayout = (LinearLayout)view.findViewById(R.id.setting_link_layout);
        TextView linkTextView = (TextView)view.findViewById(R.id.setting_link);
        linkTextView.setText("Accounts");
        parentLayout.addView(linkLayout);

        linkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view = inflater.inflate(R.layout.account_settings_layout, parentLayout, false);
                LinearLayout linkLayout = (LinearLayout) view.findViewById(R.id.account_settings_layout);

                parentLayout.removeViewAt(0);

                parentLayout.addView(linkLayout,0);
            }
        });

        view = inflater.inflate(R.layout.single_setting_layout, parentLayout, false);
        linkLayout = (LinearLayout)view.findViewById(R.id.setting_link_layout);
        linkTextView = (TextView)view.findViewById(R.id.setting_link);
        linkTextView.setText("Filters");
        parentLayout.addView(linkLayout);

        linkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view = inflater.inflate(R.layout.filters_settings_layout, parentLayout, false);
                LinearLayout linkLayout = (LinearLayout) view.findViewById(R.id.filter_settings_layout);

                parentLayout.removeViewAt(1);
                parentLayout.addView(linkLayout,1);


            }
        });

        return rootView;
    }
}

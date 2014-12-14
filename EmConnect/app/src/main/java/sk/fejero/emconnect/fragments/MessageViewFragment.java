package sk.fejero.emconnect.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sk.fejero.emconnect.R;

/**
 * Created by fejero on 27.11.2014.
 */
public class MessageViewFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_message, container, false);
    }
}

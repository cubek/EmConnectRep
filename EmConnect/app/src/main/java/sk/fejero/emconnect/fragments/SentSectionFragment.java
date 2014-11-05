package sk.fejero.emconnect.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import sk.fejero.emconnect.R;

/**
 * Created by fejero on 23.10.2014.
 */
public class SentSectionFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sent, container, false);

        LinearLayout parentLayout = (LinearLayout)rootView.findViewById(R.id.sent_list_layout);
        LinearLayout leftBarLayout = (LinearLayout)rootView.findViewById(R.id.sent_link_list_layout);

        view = inflater.inflate(R.layout.left_bar_link_layout, parentLayout, false);
        LinearLayout linkLayout = (LinearLayout)view.findViewById(R.id.link_content_layout);
        TextView linkTextView = (TextView)view.findViewById(R.id.link_content);
        linkTextView.setText("Sent");
        leftBarLayout.addView(linkLayout);

        view = inflater.inflate(R.layout.left_bar_link_layout, parentLayout, false);
        linkLayout = (LinearLayout)view.findViewById(R.id.link_content_layout);
        linkTextView = (TextView)view.findViewById(R.id.link_content);
        linkTextView.setText("Concepts");
        leftBarLayout.addView(linkLayout);



        for (int i = 1; i < 4; i++){
            // Add the text layout to the parent layout
            view = inflater.inflate(R.layout.single_sent_layout, parentLayout, false);

            LinearLayout textViewLayout = (LinearLayout)view.findViewById(R.id.sent_text_layout);
            TextView senderTextView = (TextView)view.findViewById(R.id.sent_sender);
            senderTextView.setText("fejero@fejero.com");

            TextView topicTextView = (TextView)view.findViewById(R.id.sent_topic);
            topicTextView.setText("Job application");


            TextView contentTextView = (TextView)view.findViewById(R.id.sent_content);
            contentTextView.setText("Ponuka, ktorá sa neodmieta? No predsa stovky Blu-ray filmov s brutálnym zľavami! :-) Alebo máte chuť radšej na filmové novinky? Nie je problém! Samozrejme, zabudnúť nemôžeme ani na milovníkov hudby. A keď už kvalitné zážitky, tak so šálkou chutného čaju alebo v romantickom prítmí luxusných sviečok Alusi. :-) Nestačí? Nevadí, ešte oveľa viac toho nájdete len o kúsok nižšie. Prajeme krásny víkend, milí priatelia! :-)");

            TextView dateTextView = (TextView)view.findViewById(R.id.sent_date);
            dateTextView.setText("30.10.2014");


            // Add the text view to the parent layout
            parentLayout.addView(textViewLayout);
        }
        return rootView;
    }
}

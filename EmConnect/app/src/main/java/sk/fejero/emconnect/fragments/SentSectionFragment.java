package sk.fejero.emconnect.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import sk.fejero.emconnect.R;
import sk.fejero.emconnect.management.ContainerManagement;
import sk.fejero.emconnect.management.DataLoader;
import sk.fejero.emconnect.messages.ConceptMessage;
import sk.fejero.emconnect.messages.SentMessage;

/**
 * Created by fejero on 23.10.2014.
 */
public class SentSectionFragment extends Fragment {

    private View linkView;
    private View messageView;
    private View contentView;

    private int defaultTextColor;
    private TextView currentLinkView;
    private int currentLinkColor = Color.RED;
    private DataLoader loader;
    private ContainerManagement cm;


    public SentSectionFragment() {

    }

    public void loadLoader(DataLoader loader, ContainerManagement cm){
        this.loader = loader;
        this.cm = cm;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sent, container, false);

        LinearLayout contentParentLayout = (LinearLayout)rootView.findViewById(R.id.sent_list);
        LinearLayout leftBarParentLayout = (LinearLayout)rootView.findViewById(R.id.sent_link_list_layout);

        initSideBar(inflater,leftBarParentLayout,contentParentLayout);
        loader.loadSent(cm);
        loader.loadConcepts(cm);
        initSentContent(inflater, contentParentLayout);

        return rootView;
    }

    private void initSideBar(final LayoutInflater inflater, LinearLayout leftBarParentLayout, final LinearLayout contentParentLayout){
        linkView = inflater.inflate(R.layout.left_bar_link_layout, leftBarParentLayout, false);
        LinearLayout linkLayout = (LinearLayout)linkView.findViewById(R.id.link_content_layout);
        final TextView sentLinkTextView = (TextView)linkView.findViewById(R.id.link_content);
        sentLinkTextView.setText("Sent");

        final int currentTextColor = sentLinkTextView.getCurrentTextColor();
        currentLinkView = sentLinkTextView;

        defaultTextColor = currentTextColor;
        currentLinkView = sentLinkTextView;
        sentLinkTextView.setTextColor(currentLinkColor);


        sentLinkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentLinkView.setTextColor(defaultTextColor);
                sentLinkTextView.setTextColor(currentLinkColor);
                currentLinkView = sentLinkTextView;
                contentParentLayout.removeViewAt(0);
                initSentContent(inflater,contentParentLayout);
            }
        });
        leftBarParentLayout.addView(linkLayout);

        linkView = inflater.inflate(R.layout.left_bar_link_layout, leftBarParentLayout, false);
        linkLayout = (LinearLayout)linkView.findViewById(R.id.link_content_layout);
        final TextView conceptsLinkTextView = (TextView)linkView.findViewById(R.id.link_content);
        conceptsLinkTextView.setText("Concepts");
        conceptsLinkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentLinkView.setTextColor(defaultTextColor);
                conceptsLinkTextView.setTextColor(currentLinkColor);
                currentLinkView = conceptsLinkTextView;
                contentParentLayout.removeViewAt(0);
                initConceptsContent(inflater,contentParentLayout);
            }
        });
        leftBarParentLayout.addView(linkLayout);
    }

    private void initSentContent(LayoutInflater inflater,LinearLayout contentParentLayout){
        contentView = inflater.inflate(R.layout.sent_list_layout, contentParentLayout, false);

        LinearLayout contentScrollView = (LinearLayout)contentView.findViewById(R.id.sentScrollLayout);
        LinearLayout contentScrollLayout = (LinearLayout)contentView.findViewById(R.id.sent_list_layout);
        contentParentLayout.addView(contentScrollView);



        for (SentMessage m : cm.getSentMessageList()){
            messageView = inflater.inflate(R.layout.single_inbox_layout, contentScrollLayout, false);
            LinearLayout textViewLayout = (LinearLayout)messageView.findViewById(R.id.inbox_text_layout);

            TextView senderTextView = (TextView)messageView.findViewById(R.id.inbox_sender);
            senderTextView.setText(m.getAddress());

            TextView topicTextView = (TextView)messageView.findViewById(R.id.inbox_topic);
            topicTextView.setText(m.getSubject());

            TextView contentTextView = (TextView)messageView.findViewById(R.id.inbox_content);
            contentTextView.setText(m.getContent());

            TextView dateTextView = (TextView)messageView.findViewById(R.id.inbox_date);
            dateTextView.setText(m.getDate().toString());

            // Add the text view to the parent layout
            contentScrollLayout.addView(textViewLayout);
        }
    }


    private void initConceptsContent(LayoutInflater inflater,LinearLayout contentParentLayout){
        contentView = inflater.inflate(R.layout.sent_list_layout, contentParentLayout, false);

        LinearLayout contentScrollView = (LinearLayout)contentView.findViewById(R.id.sentScrollLayout);
        LinearLayout contentScrollLayout = (LinearLayout)contentView.findViewById(R.id.sent_list_layout);
        contentParentLayout.addView(contentScrollView);



        for (ConceptMessage m : cm.getConceptMessageList()){
            messageView = inflater.inflate(R.layout.single_inbox_layout, contentScrollLayout, false);
            LinearLayout textViewLayout = (LinearLayout)messageView.findViewById(R.id.inbox_text_layout);

            TextView senderTextView = (TextView)messageView.findViewById(R.id.inbox_sender);
            senderTextView.setText(m.getAddress());

            TextView topicTextView = (TextView)messageView.findViewById(R.id.inbox_topic);
            topicTextView.setText(m.getSubject());

            TextView contentTextView = (TextView)messageView.findViewById(R.id.inbox_content);
            contentTextView.setText(m.getContent());

            TextView dateTextView = (TextView)messageView.findViewById(R.id.inbox_date);
            dateTextView.setText(m.getDate().toString());

            // Add the text view to the parent layout
            contentScrollLayout.addView(textViewLayout);
        }
    }
}

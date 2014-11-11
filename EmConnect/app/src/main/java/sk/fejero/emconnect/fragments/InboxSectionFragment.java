package sk.fejero.emconnect.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sk.fejero.emconnect.R;
import sk.fejero.emconnect.management.ContainerManagement;
import sk.fejero.emconnect.management.DataLoader;
import sk.fejero.emconnect.messages.InboxMessage;
import sk.fejero.emconnect.messages.SpamMessage;
import sk.fejero.emconnect.messages.TrashMessage;

/**
 * Created by fejero on 23.10.2014.
 */
public class InboxSectionFragment extends Fragment {

    private View linkView;
    private View messageView;
    private View contentView;
    private DataLoader loader;
    private ContainerManagement cm;
    private List<TextView> linkList;
    private int defaultTextColor;
    private TextView currentLinkView;
    int currentLinkColor = Color.RED;

    public InboxSectionFragment() {

    }

    public void loadLoader(DataLoader loader, ContainerManagement cm){
        this.loader = loader;
        this.cm = cm;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_inbox, container, false);
        LinearLayout contentParentLayout = (LinearLayout)rootView.findViewById(R.id.inbox_list);
        LinearLayout leftBarParentLayout = (LinearLayout)rootView.findViewById(R.id.inbox_link_list_layout);

        linkList = new ArrayList<TextView>();

        initSideBar(inflater,leftBarParentLayout,contentParentLayout);
        loader.loadInbox(cm);
        loader.loadSpam(cm);
        loader.loadTrash(cm);
        initInboxContent(inflater,contentParentLayout);

        return rootView;
    }


    private void initSideBar(final LayoutInflater inflater, LinearLayout leftBarParentLayout, final LinearLayout contentParentLayout){

        linkView = inflater.inflate(R.layout.left_bar_link_layout, leftBarParentLayout, false);
        LinearLayout linkLayout = (LinearLayout)linkView.findViewById(R.id.link_content_layout);
        final TextView inboxLinkTextView = (TextView)linkView.findViewById(R.id.link_content);
        inboxLinkTextView.setText("Inbox");
        //inboxLinkTextView.setTextColor(Color.DKGRAY);
        final int currentTextColor = inboxLinkTextView.getCurrentTextColor();
        currentLinkView = inboxLinkTextView;

        defaultTextColor = currentTextColor;
        currentLinkView = inboxLinkTextView;
        inboxLinkTextView.setTextColor(currentLinkColor);

        inboxLinkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentLinkView.setTextColor(defaultTextColor);
                inboxLinkTextView.setTextColor(currentLinkColor);
                currentLinkView = inboxLinkTextView;
                contentParentLayout.removeViewAt(0);
                initInboxContent(inflater, contentParentLayout);

            }
        });
        leftBarParentLayout.addView(linkLayout);

        linkView = inflater.inflate(R.layout.left_bar_link_layout, leftBarParentLayout, false);
        linkLayout = (LinearLayout)linkView.findViewById(R.id.link_content_layout);
        final TextView spamLinkTextView = (TextView)linkView.findViewById(R.id.link_content);
        spamLinkTextView.setText("Spam");
        spamLinkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentLinkView.setTextColor(defaultTextColor);
                spamLinkTextView.setTextColor(currentLinkColor);
                currentLinkView = spamLinkTextView;
                contentParentLayout.removeViewAt(0);
                initSpamContent(inflater, contentParentLayout);
            }
        });
        leftBarParentLayout.addView(linkLayout);

        linkView = inflater.inflate(R.layout.left_bar_link_layout, leftBarParentLayout, false);
        linkLayout = (LinearLayout)linkView.findViewById(R.id.link_content_layout);
        final TextView trashLinkTextView = (TextView)linkView.findViewById(R.id.link_content);
        trashLinkTextView.setText("Trash");
        trashLinkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentLinkView.setTextColor(defaultTextColor);
                trashLinkTextView.setTextColor(currentLinkColor);
                currentLinkView = trashLinkTextView;
                contentParentLayout.removeViewAt(0);
                initTrashContent(inflater, contentParentLayout);
            }
        });
        leftBarParentLayout.addView(linkLayout);

    }

    private void initInboxContent(LayoutInflater inflater, LinearLayout contentParentLayout){

        contentView = inflater.inflate(R.layout.inbox_list_layout, contentParentLayout, false);

        LinearLayout contentScrollView = (LinearLayout)contentView.findViewById(R.id.inboxScrollLayout);
        LinearLayout contentScrollLayout = (LinearLayout)contentView.findViewById(R.id.inbox_list_layout);
        contentParentLayout.addView(contentScrollView);



        for (InboxMessage m : cm.getInboxMessageList()){
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



    private void initSpamContent(LayoutInflater inflater, LinearLayout contentParentLayout){


        contentView = inflater.inflate(R.layout.inbox_list_layout, contentParentLayout, false);

        LinearLayout contentScrollView = (LinearLayout)contentView.findViewById(R.id.inboxScrollLayout);
        LinearLayout contentScrollLayout = (LinearLayout)contentView.findViewById(R.id.inbox_list_layout);
        contentParentLayout.addView(contentScrollView);

        for (SpamMessage m : cm.getSpamMessageList()){
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

    private void initTrashContent(LayoutInflater inflater, LinearLayout contentParentLayout){


        contentView = inflater.inflate(R.layout.inbox_list_layout, contentParentLayout, false);

        LinearLayout contentScrollView = (LinearLayout)contentView.findViewById(R.id.inboxScrollLayout);
        LinearLayout contentScrollLayout = (LinearLayout)contentView.findViewById(R.id.inbox_list_layout);
        contentParentLayout.addView(contentScrollView);

        for (TrashMessage m : cm.getTrashMessageList()){
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

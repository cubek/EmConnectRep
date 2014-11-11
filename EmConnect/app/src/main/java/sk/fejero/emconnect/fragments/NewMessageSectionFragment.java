package sk.fejero.emconnect.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Date;

import sk.fejero.emconnect.R;
import sk.fejero.emconnect.management.ContainerManagement;
import sk.fejero.emconnect.management.DataLoader;
import sk.fejero.emconnect.messages.ConceptMessage;
import sk.fejero.emconnect.messages.Message;
import sk.fejero.emconnect.messages.SentMessage;
import sk.fejero.emconnect.models.NewMessageModel;

/**
 * Created by fejero on 23.10.2014.
 */
public class NewMessageSectionFragment extends Fragment {

    private EditText addressEditText;
    private EditText ccEditText;
    private EditText subjectEditText;
    private EditText contentEditText;
    private ImageButton emailSendButton;
    private ImageButton emailSaveButton;
    private ImageButton attachementButton;

    private NewMessageModel model;


    public NewMessageSectionFragment() {

    }

    public void loadModel(NewMessageModel model){
        this.model = model;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_new_message, container, false);

        addressEditText = (EditText)rootView.findViewById(R.id.address_edit_text);
        ccEditText = (EditText)rootView.findViewById(R.id.cc_edit_text);
        subjectEditText = (EditText)rootView.findViewById(R.id.subject_edit_text);
        contentEditText = (EditText)rootView.findViewById(R.id.content_edit_text);
        emailSendButton = (ImageButton)rootView.findViewById(R.id.email_send_button);
        emailSaveButton = (ImageButton)rootView.findViewById(R.id.email_save_button);
        attachementButton = (ImageButton)rootView.findViewById(R.id.attachements_button);


        emailSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SentMessage sentMessage = new SentMessage(new Date(),addressEditText.getText().toString(),subjectEditText.getText().toString(),ccEditText.getText().toString(),contentEditText.getText().toString());
                model.sendEmail(sentMessage);
            }
        });

        attachementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.loadAttachement();
            }
        });

        emailSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConceptMessage conceptMessage = new ConceptMessage(new Date(),addressEditText.getText().toString(),subjectEditText.getText().toString(),ccEditText.getText().toString(),contentEditText.getText().toString());
                model.saveEmailToConcepts(conceptMessage);
            }
        });

        return rootView;
    }
}

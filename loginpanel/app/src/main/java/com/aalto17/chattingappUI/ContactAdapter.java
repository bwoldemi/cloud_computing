package com.aalto17.chattingappUI;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;


public class ContactAdapter extends

        ArrayAdapter<Contact> implements View.OnClickListener{

    private ArrayList<Contact> dataset;
    private Context mContext;

    public ContactAdapter(ArrayList<Contact> dataset, Context context) {
        super(context, R.layout.contacts_layout, dataset);
        this.dataset = dataset;
        this.mContext = context;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);

        convertView = inflater.inflate(R.layout.contacts_layout, parent, false);

        TextView nameTextView = convertView.findViewById(R.id.contact_name);
        nameTextView.setText(dataset.get(position).getContactName());

        TextView messageTextView =convertView.findViewById(R.id.contact_message);
        messageTextView.setText(dataset.get(position).getMessage());
        return convertView;
    }

    @Override
    public void onClick(View v) {

    }
}

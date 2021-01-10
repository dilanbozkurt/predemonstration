package com.example.project;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class messageFragment extends Fragment {

    public static messageFragment getInstance(){
        messageFragment messageFragment=new messageFragment();
        return messageFragment;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    Button buttonMessage;
    DatabaseReference database;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.sendmessage,container,false);

        buttonMessage=view.findViewById(R.id.buttonMessage);

        buttonMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database= FirebaseDatabase.getInstance().getReference().child("users");
                database.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String Contact = snapshot.child("contact").getValue().toString();
                        String msg = "I NEED HELP";
                        if (ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.SEND_SMS}, 1);
                        } else {
                            try {
                                buttonMessage.setBackgroundResource(R.drawable.button_pressed);
                                SmsManager smsManager = SmsManager.getDefault();
                                smsManager.sendTextMessage(String.valueOf(Contact), null, msg, null, null);
                                Toast.makeText(getActivity().getApplicationContext(), "Message is sent to your contact number.", Toast.LENGTH_LONG).show();
                            } catch (Exception e) {
                                Toast.makeText(getActivity().getApplicationContext(), "Some fields are empty", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
        return view;
    }
}

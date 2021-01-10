package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class savedInfoAct extends AppCompatActivity {

    TextView textGoster;
    TextView textGoster2;
    TextView textGoster3;
    TextView textGoster4;
    TextView textGoster5;
    TextView textGoster6;
    TextView textGoster7;

    DatabaseReference database;
    DatabaseReference database2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_info);

        textGoster=findViewById(R.id.textView3);
        textGoster2=findViewById(R.id.textView8);
        textGoster3=findViewById(R.id.textView10);
        textGoster4=findViewById(R.id.textView11);
        textGoster5=findViewById(R.id.textView12);
        textGoster6=findViewById(R.id.textView13);
        textGoster7=findViewById(R.id.textView14);

        database= FirebaseDatabase.getInstance().getReference().child("users");
        database2= FirebaseDatabase.getInstance().getReference().child("info");

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Name=snapshot.child("name").getValue().toString();
                String Mail=snapshot.child("mail").getValue().toString();
                String Age=snapshot.child("age").getValue().toString();
                String Contact=snapshot.child("contact").getValue().toString();

                textGoster.setText("Name and surname: "+"\n"+Name);
                textGoster2.setText("Mail: "+"\n"+Mail);
                textGoster3.setText("Age: "+"\n"+Age);
                textGoster4.setText("Emergency number: "+"\n"+Contact);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        database2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Chronic=snapshot.child("chronicDisease").getValue().toString();
                String bloodType=snapshot.child("bloodType").getValue().toString();
                String inst=snapshot.child("medicalInstrument").getValue().toString();

                textGoster5.setText("Chronic Diseases: "+"\n"+Chronic);
                textGoster6.setText("Blood Type: "+"\n"+bloodType);
                textGoster7.setText("Medical Instrument: "+"\n"+inst);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}
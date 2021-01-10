package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class secondRegisterAct extends AppCompatActivity {
    Button saveButton;
    Button donorButton;

    EditText editChronic;
    EditText editInst;
    EditText editBlood;
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_register);


        editChronic=findViewById(R.id.editChronic);
        editInst=findViewById(R.id.editInst);
        editBlood=findViewById(R.id.editBlood);


        saveButton=findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(secondRegisterAct.this,MainActivity.class);
                Toast.makeText(getApplicationContext(),"Your information has been registered.",Toast. LENGTH_SHORT).show();

                rootNode=FirebaseDatabase.getInstance();
                reference=rootNode.getReference("info");

                String chronicDisease=editChronic.getText().toString();
                String medicalInstrument=editInst.getText().toString();
                String bloodType=editBlood.getText().toString();

                helperClass helperClass=new helperClass(chronicDisease,medicalInstrument,bloodType);
                reference.setValue(helperClass);

                startActivity(intent);
            }
        });

        donorButton=findViewById(R.id.donorButton);
        donorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tonv.org.tr/"));
                startActivity(intent);
            }
        });


    }
}
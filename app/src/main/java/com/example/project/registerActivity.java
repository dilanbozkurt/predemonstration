package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registerActivity extends AppCompatActivity {

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    Button buttonNext;
    EditText editName;
    EditText editMail;
    EditText editAge;
    EditText editContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editName=findViewById(R.id.editName);
        editMail=findViewById(R.id.editMail);
        editAge=findViewById(R.id.editAge);
        editContact=findViewById(R.id.editContact);


        buttonNext=findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(registerActivity.this,secondRegisterAct.class);

                rootNode=FirebaseDatabase.getInstance();
                reference=rootNode.getReference("users");


                String name=editName.getText().toString();
                String mail=editMail.getText().toString();
                String age=editAge.getText().toString();
                String contact=editContact.getText().toString();

                helperClass helperClass=new helperClass(name,mail,age,contact);
                reference.setValue(helperClass);

                startActivity(intent);
            }
        });

    }
}
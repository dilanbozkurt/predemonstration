package com.example.project;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private ImageButton registerButton;
    private ImageButton infoButton;
    private ImageButton firstAidButton;
    private ImageButton hospitalButton;
    private ImageButton alarmButton;
    private ImageButton guardButton;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //INFO BUTTON
        infoButton=findViewById(R.id.infoButton);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,savedInfoAct.class);
                startActivity(intent);
            }
        });


        //REGISTER BUTTON
        registerButton=findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,registerActivity.class);
                startActivity(intent);
            }
        });

        //FIRST-AID BUTTON
        firstAidButton=findViewById(R.id.firstAidButton);

        firstAidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,firstAidActivity.class);
                startActivity(intent);
        }
        });

        //HOSPITAL BUTTON
        hospitalButton=findViewById(R.id.hospitalButton);
        hospitalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });

        //ALARM BUTTON
        alarmButton=findViewById(R.id.alarmButton);
        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,alarmActivity.class);
                startActivity(intent);
            }
        });

        //GUARD BUTTON
        guardButton=findViewById(R.id.guardButton);
        guardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,tabGuardActivity.class);
                startActivity(intent);
            }
        });
    }



    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

}
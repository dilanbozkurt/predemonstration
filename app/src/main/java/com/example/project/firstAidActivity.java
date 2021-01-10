package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class firstAidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid);


        Window v=getWindow();
        v.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        RecyclerView recyclerView=findViewById(R.id.rv_list);

        List<item> mlist=new ArrayList<>();
        mlist.add(new item(R.drawable.bogulma,"Choking"));
        mlist.add(new item(R.drawable.yanmaa,"Burning"));
        mlist.add(new item(R.drawable.kalpkrizi,"Heart Attack"));
        mlist.add(new item(R.drawable.shockpicture,"Shock"));
        mlist.add(new item(R.drawable.kanama,"Bleeding"));
        mlist.add(new item(R.drawable.kirik,"Broken"));


        Adapter adapter=new Adapter(this,mlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }
}
package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class bleedingActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private slideAdapterBleeding myAdapter;
    private TextView[] mDots;
    private LinearLayout dotsLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bleeding);

        viewPager=findViewById(R.id.viewPages);
        myAdapter=new slideAdapterBleeding(this);
        viewPager.setAdapter(myAdapter);
        dotsLayout=(LinearLayout) findViewById(R.id.dotsLayout);
        addDotsIndicator(0);
        viewPager.addOnPageChangeListener(viewListener);
    }

    public void addDotsIndicator(int position){
        mDots=new TextView[6];
        dotsLayout.removeAllViews();


        for(int i=0;i<mDots.length;i++){
            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.transparentWhite));

            dotsLayout.addView(mDots[i]);
        }
        if(mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.White));
        }
    }
    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}

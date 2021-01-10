package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class slideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    public int[] list_images={
            R.drawable.choking1,
            R.drawable.choking2,
            R.drawable.choking2,
            R.drawable.choking2
    };

    //list of titles
    public String[] list_title={
            "STEP 1",
            "STEP 2",
            "STEP 3",
            "STEP 4"
    };

    public String[] list_description={
            "If the casualty is breathing,\n" +
                    "encourage her to continue\n" +
                    "coughing. If she is not coughing\n" +
                    "and not able to breathe, she is\n" +
                    "choking. ",
            "Stand behind the person with one leg back and other between their leg and put both arms around the upper part of her abdomen. Clench your fist with your thumb on top of your index finger and place it between the navel and the bottom of her breastbone. Hold the fist with other hand.Thrust sharply inward and upward until the object is out.",
            "If the casualty loses consciousness, carefully support her to the floor, immediately call 112 for emergency help or send someone to do so, then begin CPR with chest compressions. Each time the airway is opened during CPR, look for an object in the casualty's mouth and, if seen, remove it.",
            "If the obstruction still has\n" +
                    "not cleared, continue CPR\n" +
                    "until help arrives."
    };


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutSlide=view.findViewById(R.id.slideLinearLayout);
        ImageView imgSlide=(ImageView) view.findViewById(R.id.slideImg);
        TextView textTitle=view.findViewById(R.id.textTitle);
        TextView description=view.findViewById(R.id.description);
        //layoutSlide.setBackgroundColor(list_background[position]);
        imgSlide.setImageResource(list_images[position]);
        textTitle.setText(list_title[position]);
        description.setText((list_description[position]));
        container.addView(view);
        return view;

    }

    public int[] list_background={
            R.drawable.mavi6,
            R.drawable.mavi6,
            R.drawable.mavi6,
            R.drawable.mavi6
    };

    public slideAdapter(Context context){
        this.context=context;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }

    @Override
    public int getCount() {
        return list_title.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }
}

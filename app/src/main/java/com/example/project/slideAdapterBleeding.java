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

public class slideAdapterBleeding extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    public int[] list_images={
            R.drawable.bleeding1,
            R.drawable.bleeding2,
            R.drawable.bleeding3,
            R.drawable.bleeding4,
            R.drawable.bleeding4,
            R.drawable.bleeding4
    };

    //list of titles
    public String[] list_title={
            "STEP 1",
            "STEP 2",
            "STEP 3",
            "STEP 4",
            "STEP 5",
            "STEP 6"
    };

    public String[] list_description={
            "Apply direct pressure over the wound with your fingers using a sterile dressing or clean, gauze pad. If you do not have a dressing, ask the casualty to apply direct pressure himself. If there is an object in the wound, apply pressure on either side of the object (opposite).",
            "Maintain direct pressure\n" +
                    "on the wound to control\n" +
                    "bleeding. Raise and support\n" +
                    "the injured limb above the level\n" +
                    "of the casualty’s heart to reduce\n" +
                    "blood loss.",
            "Help the casualty lie down—on a rug or blanket if there is one, because this will protect him from the cold. Since shock may develop, raise and support his legs so that they are above the level of his heart. Ask a helper to call 112 for emergency help, and to give the dispatcher details of the site and extent of the bleeding.",
            "Secure the dressing with a bandage that is firm enough to maintain pressure, but not so tight that it impairs circulation. Call 112 for emergency help if this has not been done already.",
            "If bleeding shows through the dressing, apply a second one on top of the first. If blood seeps through the second dressing, remove both and apply a fresh one, ensuring that pressure is applied accurately at the point of bleeding.",
            "Support the injured part in a raised position with a sling and/or bandage. Check the circulation beyond the bandage every ten minutes If the circulation is impaired,loosen the bandage and reapply,monitor vital signs of response, breathing,and pulse.\n"
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
            R.drawable.mavi6,
            R.drawable.mavi6,
            R.drawable.mavi6
    };

    public slideAdapterBleeding(Context context){
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

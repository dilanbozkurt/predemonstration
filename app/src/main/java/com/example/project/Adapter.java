package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {

    Context mContext;
    List<item> mData;


    public Adapter(Context mContext, List<item> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v=inflater.inflate(R.layout.card_item,parent,false);
        return new myViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, final int position) {

        holder.background_img.setImageResource(mData.get(position).getBackground());
        holder.tv_title.setText(mData.get(position).getTitleName());


        holder.btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mData.get(position).getTitleName().equals("Choking")) {
                    Intent intent = new Intent(mContext, chokingActivity.class);
                    mContext.startActivity(intent);
                }
                else if(mData.get(position).getTitleName().equals("Burning")) {
                    Intent intent = new Intent(mContext, burningActivity.class);
                    mContext.startActivity(intent);
                }
                else if(mData.get(position).getTitleName().equals("Heart Attack")) {
                    Intent intent = new Intent(mContext, heartActivity.class);
                    mContext.startActivity(intent);
                }
                else if(mData.get(position).getTitleName().equals("Shock")) {
                    Intent intent = new Intent(mContext, shockActivity.class);
                    mContext.startActivity(intent);
                }
                else if(mData.get(position).getTitleName().equals("Bleeding")) {
                    Intent intent = new Intent(mContext, bleedingActivity.class);
                    mContext.startActivity(intent);
                }
                else {
                    Intent intent = new Intent(mContext, brokenActivity.class);
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        ImageView background_img;
        TextView tv_title;
        Button btn_click;

        public myViewHolder(View itemView) {
            super(itemView);
            background_img=itemView.findViewById(R.id.card_bg);
            tv_title=itemView.findViewById(R.id.textTitle);
            btn_click=itemView.findViewById(R.id.btn_click);
        }


    }
}

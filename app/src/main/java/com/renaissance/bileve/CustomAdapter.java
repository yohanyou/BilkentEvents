package com.renaissance.bileve;
/*
This class creates Adapter class for displaying bunch of elements by taking the details of the Events.

 */

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;
    private Context context;
    private ArrayList<String> event_id, event_title, event_lang, event_date, event_loc;


    CustomAdapter(Context context, ArrayList event_id,ArrayList event_title,ArrayList event_lang, ArrayList event_date,ArrayList event_loc, RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.event_id = event_id;
        this.event_title = event_title;
        this.event_lang = event_lang;
        this.event_date = event_date;
        this.event_loc = event_loc;
        this.recyclerViewInterface = recyclerViewInterface;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view, recyclerViewInterface);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.event_id_txt.setText(String.valueOf(event_id.get(position)));
        holder.event_title_txt.setText(String.valueOf(event_title.get(position)));
        holder.event_date_txt.setText(String.valueOf(event_date.get(position)));
        holder.event_lang_txt.setText(String.valueOf(event_lang.get(position)));
        holder.event_loc_txt.setText(String.valueOf(event_loc.get(position)));
    }

    @Override
    public int getItemCount() {
        return event_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView event_id_txt, event_title_txt, event_date_txt, event_lang_txt, event_loc_txt;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            event_id_txt=itemView.findViewById(R.id.event_id_txt);
            event_title_txt=itemView.findViewById(R.id.event_title_txt);
            event_date_txt=itemView.findViewById(R.id.event_date_txt);
            event_lang_txt=itemView.findViewById(R.id.event_lang_txt);
            event_loc_txt=itemView.findViewById(R.id.event_loc_txt);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface != null){

                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }

                    }

                }
            });


            };

        }




}

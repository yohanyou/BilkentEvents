package com.renaissance.bileve;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;



public class Schedule extends RecyclerView.Adapter<Schedule.MyViewHolder> {

    String name;
    String id;
    String loc;
    String lang;
    String day;

    RecyclerViewInterface recyclerViewInterface;
    Context context;



    public Schedule(Context context, String id, String title, String lang, String date, String loc)
    {
        this.name = title;
        this.day = date;
        this.id = id;
        this.loc = loc;
        this.lang = lang;
        this.context = context;
    }

    public String getTime()
    {
        return this.day;
    }
    public String getName() {return this.name;}
    public String getLocationx()
    {
        return this.loc;
    }
    public String getLanguagex()
    {
        return this.lang;
    }
    public String getIdx()
    {
        return this.id;
    }




    @NonNull
    @Override
    public Schedule.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new Schedule.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Schedule.MyViewHolder holder, int position) {

        holder.event_id_txt.setText(id);
        holder.event_title_txt.setText(name);
        holder.event_date_txt.setText(day);
        holder.event_lang_txt.setText(lang);
        holder.event_loc_txt.setText(loc);


    }

    @Override
    public int getItemCount() {
        return name.length();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView event_id_txt, event_title_txt, event_date_txt, event_lang_txt, event_loc_txt;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            event_id_txt=itemView.findViewById(R.id.event_id_txt);
            event_title_txt=itemView.findViewById(R.id.event_title_txt);
            event_date_txt=itemView.findViewById(R.id.event_date_txt);
            event_lang_txt=itemView.findViewById(R.id.event_lang_txt);
            event_loc_txt=itemView.findViewById(R.id.event_loc_txt);
        }
    }



    // We will have a schedule object to keep the details of the registered schedule.
    // for adding next events
    // compare events for adding
    // if not in the list add it to the Schedule object and register
    //
    // then in Schedule class it will display the registered events


}
package com.renaissance.bileve;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class AdapterOfEvents extends RecyclerView.Adapter<AdapterOfEvents.MyViewHolder> {

    Context context;
    ArrayList<Events> events;

    public AdapterOfEvents(Context context, ArrayList<Events> events)
    {

        this.context = context;
        this.events = events;

    }

    @NonNull
    @Override
    public AdapterOfEvents.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_rows, parent, false);

        return new AdapterOfEvents.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterOfEvents.MyViewHolder holder, int position) {


        holder.eventName.setText(events.get(position).getEventName());
        holder.clubName.setText(events.get(position).getClubName());
        holder.date.setText(events.get(position).getDate());
        holder.time.setText(events.get(position).getTime());
        holder.location.setText(events.get(position).getLocation());
        holder.capacity.setText(events.get(position).getCapacity());



    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView eventName, clubName, date, time, location,capacity;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            eventName = itemView.findViewById(R.id.eventName);
            clubName = itemView.findViewById(R.id.clubName);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            location = itemView.findViewById(R.id.location);
            capacity = itemView.findViewById(R.id.capacity);


        }
    }
}

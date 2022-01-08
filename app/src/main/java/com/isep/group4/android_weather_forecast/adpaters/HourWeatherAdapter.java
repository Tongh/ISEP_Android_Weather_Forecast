package com.isep.group4.android_weather_forecast.adpaters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isep.group4.android_weather_forecast.R;
import com.isep.group4.android_weather_forecast.beans.adapter.HourWeather;

import java.util.ArrayList;

public class HourWeatherAdapter extends RecyclerView.Adapter<HourWeatherAdapter.ViewHolder> {
    private ArrayList<HourWeather> hourWeathers;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hour_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    public HourWeatherAdapter(ArrayList<HourWeather>hourWeathers){
        this.hourWeathers = hourWeathers;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HourWeather hourWeather = hourWeathers.get(position);
        holder.hour_time.setText(String.valueOf(hourWeather.getTime()));
        holder.hour_temp.setText(String.valueOf(hourWeather.getTemp()));
        int weather_id = R.drawable.frog;
        switch (hourWeather.getWeather()){
            case "Clouds":
                weather_id = R.drawable.cloud;
                break;
        }
        holder.hour_weather_icon.setImageResource(weather_id);
    }

    @Override
    public int getItemCount() {
        return hourWeathers.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView hour_time;
        ImageView hour_weather_icon;
        TextView hour_temp;

        public ViewHolder(View view) {
            super(view);
            hour_temp = view.findViewById(R.id.hour_temp);
            hour_time = view.findViewById(R.id.hour_time);
            hour_weather_icon = view.findViewById(R.id.hour_weather_icon);
        }
    }

}

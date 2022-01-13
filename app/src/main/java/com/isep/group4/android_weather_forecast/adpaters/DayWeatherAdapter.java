package com.isep.group4.android_weather_forecast.adpaters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isep.group4.android_weather_forecast.R;
import com.isep.group4.android_weather_forecast.beans.adapter.DayWeather;

import java.util.ArrayList;

public class DayWeatherAdapter extends RecyclerView.Adapter<DayWeatherAdapter.ViewHolder> {
    private ArrayList<DayWeather> dayWeathers;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.day_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    public DayWeatherAdapter(ArrayList<DayWeather>dayWeathers){
        this.dayWeathers = dayWeathers;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DayWeather dayWeather = dayWeathers.get(position);
        holder.day_date.setText(String.valueOf(dayWeather.getDate()));
        holder.day_temp.setText(String.valueOf(dayWeather.getTemp()));
        int weather_id = R.drawable.frog;
        switch (dayWeather.getWeather()){
            case "Clouds":
                weather_id = R.drawable.cloud;
                break;
        }
        holder.day_weather_icon.setImageResource(weather_id);
    }

    @Override
    public int getItemCount() {
        return dayWeathers.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView day_date;
        ImageView day_weather_icon;
        TextView day_temp;

        public ViewHolder(View view) {
            super(view);
            day_temp = view.findViewById(R.id.day_temp);
            day_date = view.findViewById(R.id.day_date);
            day_weather_icon = view.findViewById(R.id.day_icon);
        }
    }

}

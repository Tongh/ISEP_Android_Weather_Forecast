package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.weatherapp.beans.current_weather.CurrentWeather;
import com.example.weatherapp.beans.current_weather.Main;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.weatherapp.utils.tempUtil;
import com.example.weatherapp.utils.sharedPreferenceUtil;


public class WeatherActivity extends AppCompatActivity {
    public static AppCompatActivity activity;

    @BindViews({R.id.city_name, R.id.curr_temp, R.id.weather_status
            , R.id.lowest_temp, R.id.highest_temp})
    List<TextView> textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);
        setWeather();
    }

    public void setWeather() {
        CurrentWeather currentWeather = sharedPreferenceUtil.getCurrentWeather();
        Log.d("setWeather", currentWeather.toString());
        Log.d("Query_setWeather",currentWeather.getName());
        Log.d("setWeather", currentWeather.getName());
        textViews.get(0).setText(currentWeather.getName());
        //设置城市名

        Main main = currentWeather.getMain();
        Log.d("setWeather", tempUtil.transfer(main.getTemp()));
        textViews.get(1).setText(tempUtil.transfer(main.getTemp()));
        //设置温度

        Log.d("setWeather", currentWeather.getWeather().get(0).getMain());
        textViews.get(2).setText(currentWeather.getWeather().get(0).getMain());
        //设置天气状况

        Log.d("setWeather", tempUtil.transfer(main.getTemp_min()) + " " + tempUtil.transfer(main.getTemp_max()));
        textViews.get(3).setText(tempUtil.transfer(main.getTemp_min()));
        textViews.get(4).setText(tempUtil.transfer(main.getTemp_max()));
        //设置高低温度

        Intent intent = new Intent(this,UpdateService.class);
        startService(intent);
    }

    @SuppressLint("NonConstantResourceId")
    @OnClick(R.id.search_city_btn)
    public void searchCity(){
        Intent intent = new Intent(this,SearchActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setWeather();
    }
}
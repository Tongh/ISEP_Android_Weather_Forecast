package com.isep.group4.android_weather_forecast.services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.isep.group4.android_weather_forecast.WeatherActivity;
import com.isep.group4.android_weather_forecast.utils.HttpUtil;


public class UpdateService extends Service {
    AppCompatActivity activity;

    public UpdateService(){

    }

    public UpdateService(AppCompatActivity activity) {

    }

    @Override
    public void onCreate() {
        activity = WeatherActivity.activity;
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the services.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        activity = WeatherActivity.activity;
        updateWeather();
        Log.d("onStartCommand","Service: "+activity);
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        long triggerTime = SystemClock.elapsedRealtime() + 60 * 60 * 1000;
        Intent intent1 = new Intent(this, UpdateService.class);
        PendingIntent pi = PendingIntent.getService(this, 0, intent1, 0);
        manager.cancel(pi);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerTime, pi);
        return super.onStartCommand(intent, flags, startId);
    }

    public void updateWeather() {
        SharedPreferences preferences = getSharedPreferences("Location",Context.MODE_PRIVATE);
        String lat = preferences.getString("latitude", null);
        String lon = preferences.getString("longitude", null);
        if (lat != null && lon != null) {
            Log.d("onStartCommand_Weather","Service: "+activity);
            HttpUtil.requestCurrentWeather(Double.parseDouble(lat), Double.parseDouble(lon), activity);
        }
    }
}
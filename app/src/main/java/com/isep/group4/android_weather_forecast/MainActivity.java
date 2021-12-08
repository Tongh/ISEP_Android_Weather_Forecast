package com.isep.group4.android_weather_forecast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.widget.Toast;

import com.isep.group4.android_weather_forecast.beans.current_weather.CurrentWeather;
import com.isep.group4.android_weather_forecast.utils.locationUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerForActivityResult(
                new ActivityResultContracts.RequestPermission(),
                result -> {
                    if (result) {
                        locationUtil.getlocation(this,this);
                        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show();
                    }
                }).launch(Manifest.permission.ACCESS_FINE_LOCATION);
    }
}
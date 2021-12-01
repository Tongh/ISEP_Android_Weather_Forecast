package com.isep.group4.android_weather_forecast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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
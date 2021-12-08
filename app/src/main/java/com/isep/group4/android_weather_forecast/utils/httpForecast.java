package com.isep.group4.android_weather_forecast.utils;


import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;

import com.isep.group4.android_weather_forecast.beans.forecast.Forecast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class httpForecast {
    static Activity activity;

    public static void sendOkhttpRequst(String address, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }


    //double lat, double lon
    public static void handleForecast(){
        httpForecast.sendOkhttpRequst("https://api.openweathermap.org/data/2.5/onecall?lat=48.824272&lon=2.27326&appid=4b1fe12967fbc1e9b76903af4985d45f",
                new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
                        Log.d("Failed", e.toString());
                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        String responseData = response.body().string();
                        Forecast forecast = handleUtils.handleForecast(responseData);


                        try{
                            activity.runOnUiThread(()->{

                            });
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    }
                });

    }

//    public static void handleForecast(double lat, double lon){
//        httpForecast.sendOkhttpRequst("https://api.openweathermap.org/data/2.5/onecall?lat="+lat+"&lon="+lon+"&appid=4b1fe12967fbc1e9b76903af4985d45f",
//                new Callback() {
//                    @Override
//                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
//                        Log.d("Failed", "onFailure: 1111111");
//                    }
//
//                    @Override
//                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
//                        String responseData = response.body().string();
//                        convertorForecast.fromJsonToPOJO(responseData);
//
//                    }
//                });
//
//    }




}

package com.isep.group4.android_weather_forecast.utils;


import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testcitysearch.gson.CitySearch;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtil {
    public static void requestCityInfo(String cityname, AppCompatActivity activity) {
        HttpUtil.sendOkhttpRequst("https://maps.googleapis.com/maps/api/geocode/json?address=" + cityname + "&key=AIzaSyAYE39CrIN_0fcSmDERaroK_lXrE8VwWMk",
                new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                        Log.d("Http_Failure", e.toString());
                    }

                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                        String responseData = response.body().string();
                        CitySearch citySearch =  handleUtils.handleCitySearch(responseData);
                        try {
                            activity.runOnUiThread(()->{
                                if (citySearch!=null&&citySearch.getStatus().equals("OK")){

                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public static void sendOkhttpRequst(String address, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }
}

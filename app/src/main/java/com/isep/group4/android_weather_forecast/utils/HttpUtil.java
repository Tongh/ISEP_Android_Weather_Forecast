package com.isep.group4.android_weather_forecast.utils;


import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.isep.group4.android_weather_forecast.MainActivity;
import com.isep.group4.android_weather_forecast.WeatherActivity;
import com.isep.group4.android_weather_forecast.adpaters.HourWeatherAdapter;
import com.isep.group4.android_weather_forecast.beans.adapter.DayWeather;
import com.isep.group4.android_weather_forecast.beans.adapter.HourWeather;
import com.isep.group4.android_weather_forecast.beans.city.CitySearch;
import com.isep.group4.android_weather_forecast.beans.city.Geometry;
import com.isep.group4.android_weather_forecast.beans.city.Location;
import com.isep.group4.android_weather_forecast.beans.city.Results;
import com.isep.group4.android_weather_forecast.beans.current_weather.CurrentWeather;
import com.isep.group4.android_weather_forecast.beans.forecast.Daily;
import com.isep.group4.android_weather_forecast.beans.forecast.Forecast;
import com.isep.group4.android_weather_forecast.beans.forecast.Hourly;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtil {
    static int status = 0;
    public static void requestCityInfo(String cityname, AppCompatActivity activity) {
        HttpUtil.sendOkhttpRequest("https://maps.googleapis.com/maps/api/geocode/json?address=" + cityname + "&key=AIzaSyAYE39CrIN_0fcSmDERaroK_lXrE8VwWMk",
                new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                        Log.d("Http_Failure", e.toString());
                    }

                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                        String responseData = response.body().string();
                        CitySearch citySearch = handleUtils.handleCitySearch(responseData);
                        try {
                            if (citySearch != null && citySearch.getStatus().equals("OK")) {
                                Results results = citySearch.getResults().get(0);
                                Geometry geometry = results.getGeometry();
                                Location location = geometry.getLocation();
                                double lat = location.getLat();
                                double lon = location.getLng();
                                Log.d("Query_requestCityInfo", cityname + " " + results.getAddress_components().get(0).getLong_name());
                                activity.runOnUiThread(() -> {
                                    sharedPreferenceUtil.saveLatLon(activity, lat, lon);
                                    MainActivity.getWeather(activity);
                                });
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public static void requestCurrentWeather(double lat, double lon, AppCompatActivity activity) {
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat
                + "&lon=" + lon + "&appid=4b1fe12967fbc1e9b76903af4985d45f";
        HttpUtil.sendOkhttpRequest(url,
                new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                        Log.d("Http_Failure", e.toString());
                    }

                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                        String responseData = response.body().string();
                        CurrentWeather currentWeather = handleUtils.handleCurrentWeather(responseData);
                        try {
                            activity.runOnUiThread(() -> {
                                Log.d("Query_CurrentWeather", currentWeather.getName());
                                sharedPreferenceUtil.saveCurrentWeather(activity, currentWeather);
                                while (status==0){
                                    Log.d("Forecast_Hour_Weather",status+"");
                                }
                                activity.startActivity(new Intent(activity, WeatherActivity.class));
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public static void requestForecast(double lat, double lon, AppCompatActivity activity) {
        String url = "https://api.openweathermap.org/data/2.5/onecall?lat=" + lat + "&lon=" + lon + "&appid=4b1fe12967fbc1e9b76903af4985d45f";
        HttpUtil.sendOkhttpRequest(url, new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("Failed", "onFailure");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                status = 0;
                String responseData = response.body().string();
                Forecast forecast = handleUtils.handleForecast(responseData);
                Log.d("Forecast_Hour_Weather", forecast.toString());

                //将数据进行解析存入recyclerview中
                Log.d("Forecast_Hour_Weather", "runOnUiThread");
                List<Hourly> hourlies = forecast.getHourly();
                ArrayList<HourWeather> list = new ArrayList<>();
                for (Hourly hourly : hourlies) {
                    list.add(new HourWeather(timeUtil.Transfer(hourly.getDt()), hourly.getWeather().get(0).getMain(),
                            tempUtil.transfer(hourly.getTemp())));
                }
                Log.d("Forecast_Hour_Weather", "setData");
                sharedPreferenceUtil.setHourWeathers(list);


                //将每天数据进行解析存入recyclerview中
                List<Daily> dailies = forecast.getDaily();
                ArrayList<DayWeather> listDayWeather = new ArrayList<>();
                for(Daily daily : dailies) {
                    listDayWeather.add(new DayWeather(timeUtil.Transfer(daily.getDt()), daily.getWeather().get(0).getMain(),
                            tempUtil.transfer(daily.getTemp().getDay())));
                }
                sharedPreferenceUtil.setDailyWeathers(listDayWeather);
                Log.d("dailyWeatherrrrrrr", "fuckyou");

                //将echarts需要的数据存入sharedPreference里
                ArrayList<Double> minimumTempList = new ArrayList<>();
                ArrayList<Double> maximumTempList = new ArrayList<>();
                for(Daily daily : dailies){
                    minimumTempList.add(daily.getTemp().getMin());
                    maximumTempList.add(daily.getTemp().getMax());
                }
                sharedPreferenceUtil.setDailyMinMaxTemps(minimumTempList,maximumTempList);

                status = 1;
            }
        });
    }

    public static void sendOkhttpRequest(String address, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }
}

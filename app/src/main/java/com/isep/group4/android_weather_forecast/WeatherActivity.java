package com.isep.group4.android_weather_forecast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.isep.group4.android_weather_forecast.adpaters.DayWeatherAdapter;
import com.isep.group4.android_weather_forecast.adpaters.HourWeatherAdapter;
import com.isep.group4.android_weather_forecast.beans.current_weather.CurrentWeather;
import com.isep.group4.android_weather_forecast.beans.current_weather.Main;
import com.isep.group4.android_weather_forecast.echarts.EchartView;
import com.isep.group4.android_weather_forecast.echarts.echartOption;
import com.isep.group4.android_weather_forecast.services.UpdateService;
import com.isep.group4.android_weather_forecast.utils.sharedPreferenceUtil;
import com.isep.group4.android_weather_forecast.utils.tempUtil;


public class WeatherActivity extends AppCompatActivity {
    public static AppCompatActivity activity;
//    public static EchartView lineChart;

    @BindViews({R.id.city_name, R.id.curr_temp, R.id.weather_status
            , R.id.lowest_temp, R.id.highest_temp})
    List<TextView> textViews;

    @BindView(R.id.hour_recycler)
    RecyclerView recyclerView;

    @BindView(R.id.day_recycler)
    RecyclerView recyclerViewDay;

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
        Log.d("Query_setWeather", currentWeather.getName());
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

        /*
         * 设置一天的天气预报
         */
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        if (sharedPreferenceUtil.getHourWeathers().size() > 0) {
            HourWeatherAdapter hourWeatherAdapter = new HourWeatherAdapter(sharedPreferenceUtil.getHourWeathers());
            recyclerView.setAdapter(hourWeatherAdapter);
        }

        //一周天气预报echarts
        LinearLayoutManager managerDay = new LinearLayoutManager(this);
        managerDay.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewDay.setLayoutManager(managerDay);
        if(sharedPreferenceUtil.getDailyWeathers().size() > 0){
            DayWeatherAdapter dayWeatherAdapter = new DayWeatherAdapter(sharedPreferenceUtil.getDailyWeathers());
            recyclerViewDay.setAdapter(dayWeatherAdapter);
        }

        //runEcharts();

        Intent intent = new Intent(this, UpdateService.class);
        startService(intent);




    }

    @SuppressLint("NonConstantResourceId")
    @OnClick(R.id.search_city_btn)
    public void searchCity() {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setWeather();
    }

//    public void runEcharts(){
//        displayEchart();
//        lineChart = findViewById(R.id.lineChart);
//        lineChart.setWebViewClient(new WebViewClient(){
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//                //最好在h5页面加载完毕后再加载数据，防止html的标签还未加载完成，不能正常显示
//                refreshLineChart();
//            }
//        });
//    }
//
//    public void displayEchart(){
//        lineChart = findViewById(R.id.lineChart);
//        lineChart.setWebViewClient(new WebViewClient(){
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//                //最好在h5页面加载完毕后再加载数据，防止html的标签还未加载完成，不能正常显示
//                refreshLineChart();
//            }
//        });
//    }
//
//    //配置object[] x 以及 object[] y
//    private void refreshLineChart(){
//        Object[] x = new Object[]{220, 182, 191, 234, 290, 330, 310};
//        Object[] y = new Object[]{820, 932, 901, 934, 1290, 1330, 1320};
//        lineChart.refreshEchartsWithOption(echartOption.getLineChartOptions(x, y));
//    }
}
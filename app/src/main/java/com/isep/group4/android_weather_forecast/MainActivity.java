package com.isep.group4.android_weather_forecast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.isep.group4.android_weather_forecast.beans.current_weather.CurrentWeather;
import com.isep.group4.android_weather_forecast.echarts.EchartView;
import com.isep.group4.android_weather_forecast.echarts.echartOption;
import com.isep.group4.android_weather_forecast.utils.HttpUtil;
import com.isep.group4.android_weather_forecast.utils.locationUtil;
import com.isep.group4.android_weather_forecast.utils.sharedPreferenceUtil;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        registerForActivityResult(
                new ActivityResultContracts.RequestPermission(),
                result -> {
                    if (result) {
                        locationUtil.getlocation(this, this);
                        getWeather(this);
                        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show();
                    }
                }).launch(Manifest.permission.ACCESS_FINE_LOCATION);

//        displayEchart();
//
//                lineChart = findViewById(R.id.lineChart);
//        lineChart.setWebViewClient(new WebViewClient(){
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//                //最好在h5页面加载完毕后再加载数据，防止html的标签还未加载完成，不能正常显示
//                refreshLineChart();
//            }
//        });

    }

    public static void getWeather(AppCompatActivity activity) {
        //获取经纬度
        Double latitude = sharedPreferenceUtil.getLatitude();
        Double longitude = sharedPreferenceUtil.getLongitude();

        Log.d("Forecast_Hour_Weather",latitude+" "+longitude);
        HttpUtil.requestForecast(latitude, longitude, activity);
        //通过经纬度获取一天的天气预报

        HttpUtil.requestCurrentWeather(latitude, longitude, activity);
        //通过经纬度获取天气信息和城市名
    }


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

    //配置object[] x 以及 object[] y
//    private void refreshLineChart(){
//        Object[] x = new Object[]{220, 182, 191, 234, 290, 330, 310};
//        Object[] y = new Object[]{820, 932, 901, 934, 1290, 1330, 1320};
//        lineChart.refreshEchartsWithOption(echartOption.getLineChartOptions(x, y));
//    }





}
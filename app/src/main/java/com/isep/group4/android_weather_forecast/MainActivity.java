package com.isep.group4.android_weather_forecast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.widget.TextView;
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

        //        lineChart = findViewById(R.id.lineChart);
//        lineChart.setWebViewClient(new WebViewClient(){
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//                //最好在h5页面加载完毕后再加载数据，防止html的标签还未加载完成，不能正常显示
//                refreshLineChart();
//            }
//        });

    }

//    private void refreshLineChart(){
//        Object[] x = new Object[]{
//                "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
//        };
//        Object[] y = new Object[]{
//                820, 932, 901, 934, 1290, 1330, 1320
//        };
//        lineChart.refreshEchartsWithOption(echartOption.getLineChartOptions(x, y));
//    }




    public void updateCurrentWeather() {

    }




}
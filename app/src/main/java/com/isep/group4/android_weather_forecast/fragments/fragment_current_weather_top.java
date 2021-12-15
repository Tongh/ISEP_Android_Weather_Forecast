package com.isep.group4.android_weather_forecast.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.isep.group4.android_weather_forecast.R;
import com.isep.group4.android_weather_forecast.utils.HttpUtil;
import com.isep.group4.android_weather_forecast.utils.handleUtils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_current_weather_top#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_current_weather_top extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_LAT = "lat";
    private static final String ARG_LON = "lon";

    // TODO: Rename and change types of parameters
    private double lat;
    private double lon;

    private TextView tv_weather, tv_temperature;

    public fragment_current_weather_top() {
        HttpUtil.requestCurrentWeather(48.8534, 2.3486, (AppCompatActivity) getActivity());
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param lat latitude.
     * @param lon longitude.
     * @return A new instance of fragment current_weather.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_current_weather_top newInstance(double lat, double lon) {
        fragment_current_weather_top fragment = new fragment_current_weather_top();
        Bundle args = new Bundle();
        args.putDouble(ARG_LAT, lat);
        args.putDouble(ARG_LON, lon);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
        else {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current_weather_top, container, false);

        tv_weather = view.findViewById(R.id.tv_weather);
        tv_temperature = view.findViewById(R.id.tv_temperature);

        return view;
    }

    public void updateCurrentWeather() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        }).start();
    }
}
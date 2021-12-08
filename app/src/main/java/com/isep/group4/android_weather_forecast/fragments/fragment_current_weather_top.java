package com.isep.group4.android_weather_forecast.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isep.group4.android_weather_forecast.R;
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

    public fragment_current_weather_top() {
        // Required empty public constructor
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
            lat = getArguments().getDouble(ARG_LAT);
            lon = getArguments().getDouble(ARG_LON);
        }
        else {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_current_weather_top, container, false);
    }


}
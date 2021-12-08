package com.isep.group4.android_weather_forecast.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isep.group4.android_weather_forecast.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link current_weather#newInstance} factory method to
 * create an instance of this fragment.
 */
public class current_weather extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_LAT = "lat";
    private static final String ARG_LON = "lon";

    // TODO: Rename and change types of parameters
    private double lat;
    private double lon;

    public current_weather() {
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
    public static current_weather newInstance(double lat, double lon) {
        current_weather fragment = new current_weather();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_current_weather, container, false);
    }
}
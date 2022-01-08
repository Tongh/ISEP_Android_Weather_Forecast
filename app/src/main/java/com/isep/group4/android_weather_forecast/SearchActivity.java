package com.isep.group4.android_weather_forecast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.isep.group4.android_weather_forecast.utils.HttpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity {
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.searview)
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        searchView.setIconified(false);
        searchView.setSubmitButtonEnabled(true);

        searchView.setOnSearchClickListener((view) -> {

        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("Query_onQueryTextSubmit", query);
                HttpUtil.requestCityInfo(query, SearchActivity.this);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)) {
//              mListView.setFilterText(newText);
                    //mAdapter.getFilter().filter(newText);
                    //Toast.makeText(SearchActivity.this, "Not", Toast.LENGTH_SHORT).show();
                } else {
                    //mListView.clearTextFilter();
                    //Toast.makeText(SearchActivity.this, "Empty", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }
}
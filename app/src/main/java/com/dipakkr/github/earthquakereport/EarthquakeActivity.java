package com.dipakkr.github.earthquakereport;


import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity {

    private String USGS_URL =
        "http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";

    private EarthquakeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);

        QuakeAsyncTask task = new QuakeAsyncTask();
        task.execute(USGS_URL);

        final ListView earthquakeListView = (ListView)findViewById(R.id.list);
        mAdapter = new EarthquakeAdapter(this, new ArrayList<Earthquake>());
        earthquakeListView.setAdapter(mAdapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Earthquake earthquake = mAdapter.getItem(i);
                Uri earthquakeUri = Uri.parse(earthquake.getmUrl());
                Intent webIntent = new Intent(Intent.ACTION_VIEW,earthquakeUri);
                startActivity(webIntent);
            }
        });

    }
    private class QuakeAsyncTask extends AsyncTask<String,Void,List<Earthquake>>{

        private ProgressDialog progressDialog;

        @Override
        protected List<Earthquake> doInBackground(String... strings) {
            List<Earthquake> result = QueryUtils.fetchWeatherData(USGS_URL);
            return result;
        }

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(EarthquakeActivity.this);
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);
            progressDialog.show();
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(List<Earthquake> data) {
           mAdapter.clear();
            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }

            if (data != null && !data.isEmpty()){
                mAdapter.addAll(data);
            }
        }
    }

}

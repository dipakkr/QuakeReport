package com.dipakkr.github.earthquakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity {

    private String USGS_URL =
        "http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);

        ArrayList<Earthquake> earthquakes = new ArrayList<>();
        final ListView earthquakeListView = (ListView)findViewById(R.id.list);
        final EarthquakeAdapter adapter = new EarthquakeAdapter(this,earthquakes);
        earthquakeListView.setAdapter(adapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Earthquake earthquake = adapter.getItem(i);
                Uri earthquakeUri = Uri.parse(earthquake.getmUrl());
                Intent webIntent = new Intent(Intent.ACTION_VIEW,earthquakeUri);
                startActivity(webIntent);
            }
        });
    }
    private class QuakeAsyncTask extends AsyncTask<String,Void,List<Earthquake>>{

        @Override
        protected List<Earthquake> doInBackground(String... strings) {
            List<Earthquake> result = QueryUtils.fetchWeatherData(USGS_URL);
            return result;
        }

        @Override
        protected void onPostExecute(List<Earthquake> earthquakes) {
            if( earthquakes == null){
                return ;
            }
            updateUi(earthquakes);
        }
    }
    private void updateUi(List<Earthquake> earthquakes){
        TextView mag = (TextView)findViewById(R.id.magnitude);
        TextView loc = (TextView)findViewById(R.id.location);
        TextView date = (TextView)findViewById(R.id.date);
        TextView time = (TextView)findViewById(R.id.time);


    }
}

package com.dipakkr.github.earthquakereport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);

        ArrayList<Earthquake> earthquakes = new ArrayList<>();

        earthquakes.add(new Earthquake("7.2", "San Francisco", "Feb 2, 2016"));
        earthquakes.add(new Earthquake("6.1", "London", "July 20, 2015"));
        earthquakes.add(new Earthquake("3.9", "Tokyo", "Nov 10, 2014"));
        earthquakes.add(new Earthquake("5.4", "Mexico City", "May 3, 2014"));
        earthquakes.add(new Earthquake("2.8", "Moscow", "Jan 31, 2013"));
        earthquakes.add(new Earthquake("4.9", "Rio de Janeiro", "Aug 19, 2012"));
        earthquakes.add(new Earthquake("1.6", "Paris", "Oct 30, 2011"));

        // Find a reference to the {@link ListView} in the layout

        ListView earthquakeListView = (ListView)findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        EarthquakeAdapter adapter = new EarthquakeAdapter(this,earthquakes);

        earthquakeListView.setAdapter(adapter);
    }
}

package com.dipakkr.github.earthquakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by deepak on 10/12/2016.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    /**
     * Constructs a new {@link EarthquakeAdapter}.
     *
     * @param context of the app
     * @param earthquakes is the list of earthquakes, which is the data source of the adapter

     */
    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    /**
     * Returns a list item view that displays information about the earthquake at the given position
     * in the list of earthquakes.
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_items, parent, false);
        }


        // Find the earthquake at the given position in the list of earthquakes

        Earthquake currentEarthquake = getItem(position);

        TextView txtMagnitude = (TextView)listItemView.findViewById(R.id.magnitude);
        txtMagnitude.setText(currentEarthquake.getMagnitude());

        TextView txtLocation = (TextView)listItemView.findViewById(R.id.location);
        txtLocation.setText(currentEarthquake.getLocation());

        TextView txtDate = (TextView)listItemView.findViewById(R.id.date);
        txtDate.setText(currentEarthquake.getDate());


        return listItemView;

    }
}

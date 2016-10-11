package com.dipakkr.github.earthquakereport;

/**
 * Created by deepak on 10/12/2016.
 */

public class Earthquake {

    private String mMagnitude;
    private String mLocation;
    private String mDate;

     Earthquake(String magnitude, String location, String date) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
    }


    String getMagnitude() {
        return mMagnitude;
    }

    String getLocation() {
        return mLocation;
    }


    String getDate() {
        return mDate;
    }
}


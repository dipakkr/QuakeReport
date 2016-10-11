package com.dipakkr.github.earthquakereport;

/**
 * Created by deepak on 10/12/2016.
 */

public class Earthquake {

    private double mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;

     Earthquake(double magnitude, String location, long TimeInMilliseconds) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds= TimeInMilliseconds;
    }


    double getMagnitude() {
        return mMagnitude;
    }

    String getLocation() {
        return mLocation;
    }

    public long getmTimeInMilliseconds(){
        return mTimeInMilliseconds;
    }
}


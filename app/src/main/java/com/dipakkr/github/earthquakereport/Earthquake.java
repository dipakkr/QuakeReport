package com.dipakkr.github.earthquakereport;

/**
 * Created by deepak on 10/12/2016.
 */

public class Earthquake {

    public final double mMagnitude;
    public final String mLocation;
    public final long mTimeInMilliseconds;
    public final String mUrl;

     Earthquake(double magnitude, String location, long TimeInMilliseconds, String Url) {
         mMagnitude = magnitude;
         mLocation = location;
         mTimeInMilliseconds= TimeInMilliseconds;
         mUrl = Url;
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

    public String getmUrl() {
        return mUrl;
    }
}


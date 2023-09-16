package com.gopal.fast.vid.NewImplement;

import android.content.Context;
import android.net.ConnectivityManager;

public class Utils {

    public static int click = 1;
    public static int gclick = 0;
    public static String privacy = null;

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

}

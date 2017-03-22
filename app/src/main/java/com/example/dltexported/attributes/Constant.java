package com.example.dltexported.attributes;

import android.graphics.Color;

/**
 * Created by Vivek on 26-Dec-16.
 */
public class Constant {
    public static String TAG = "DLT";

    public static String PREFS_NAME = "DLT";
    public static final int[] HOME_COLORS = {
            rgb("#EA2131"), rgb("#8AC43A"), rgb("#F15A25"),
            rgb("#0C6794"), rgb("#FA9416"), rgb("#8D2C95")
    };
    public static final int[] STACKED_BAR_COLORS = {
            rgb("#A951A5"), rgb("#026697")
    };
    public static int MY_SOCKET_TIMEOUT_MS = 5000;

    public static String Authorization= "Authorization";
    public static String JWT_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE0ODk2NDUyMjYsIm5iZiI6MTQ4OTY0NTIzNiwiZXhwIjoxNDg5NjUxMjM2LCJkYXRhIjp7InVzZXJJZCI6IjYzOSIsInVzZXJOYW1lIjoidXB3b3JrQGRhaWx5bGlmZXRyYWNrZXIuY29tIn19.R23RVrG1QxRgpopZPEMG2aGIqmszAThsQpQo1xNNjo6k3jYor_n3wvh63lDk2wj-GmFu2iIOWK0pVJx1xDo8xQ";

    public static String PARENT_URL = "http://dlt.dailylifetracker.com/dltnew/api/";

    public static String URL_GET_SETTINGS = PARENT_URL + "getmysettings";
    public static String URL_GET_CATEGORIES = PARENT_URL + "getcatstats";


    // Number Constants
    public static final int GET_SETTINGS = 101;


    public static int[] getStackedColors() {

        int stacksize = 2;

        // have as many colors as stack-values per entry
        int[] colors = new int[stacksize];

        for (int i = 0; i < colors.length; i++) {
            colors[i] = STACKED_BAR_COLORS[i];
        }

        return colors;
    }

    public static int rgb(String hex) {
        int color = (int) Long.parseLong(hex.replace("#", ""), 16);
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = (color >> 0) & 0xFF;
        return Color.rgb(r, g, b);
    }
}

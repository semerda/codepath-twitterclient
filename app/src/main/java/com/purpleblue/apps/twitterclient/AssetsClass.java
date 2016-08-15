package com.purpleblue.apps.twitterclient;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ernest on 8/4/16.
 */

// Let's use this to preload the Twitter tweets JSON from local store to avoid rate limiter.
// Helpful when mucking around with the funky XML layouts.
public class AssetsClass {

    private Context context;

    public AssetsClass(Context context) {
        this.context = context;
    }

    public JSONArray loadJSONFromAsset(String filename) throws JSONException {
        String json = null;
        try {
            InputStream is = this.context.getAssets().open(String.format("%s.json", filename));
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        JSONArray jsonArray = new JSONArray(json);

        return jsonArray;
    }

    public JSONObject loadJSONObjectFromAsset(String filename) throws JSONException {
        String json = null;
        try {
            InputStream is = this.context.getAssets().open(String.format("%s.json", filename));
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        JSONObject jsonObject = new JSONObject(json);

        return jsonObject;
    }
}

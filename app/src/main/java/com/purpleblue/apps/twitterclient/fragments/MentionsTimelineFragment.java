package com.purpleblue.apps.twitterclient.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.purpleblue.apps.twitterclient.AssetsClass;
import com.purpleblue.apps.twitterclient.Constants;
import com.purpleblue.apps.twitterclient.R;
import com.purpleblue.apps.twitterclient.TwitterApplication;
import com.purpleblue.apps.twitterclient.models.Tweet;
import com.purpleblue.apps.twitterclient.net.NetworkClass;
import com.purpleblue.apps.twitterclient.net.TwitterClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by ernest on 8/10/16.
 */
public class MentionsTimelineFragment extends TweetsListFragment {

    private TwitterClient client;
    private SwipeRefreshLayout swipeContainer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!NetworkClass.isNetworkAvailable(getActivity()) && !NetworkClass.isInternetConnected()) {
            //Toast.makeText(this, "Internet appears to be down. This app needs internet to function.", Toast.LENGTH_SHORT).show();
            Snackbar.make(getActivity().findViewById(R.id.content), "Internet appears to be down. This app needs internet to function.", Snackbar.LENGTH_LONG).
                    setAction("Action", null).show();
        } else {
            // Get the client using Singleton client
            client = TwitterApplication.getRestClient(); // singleton client
            // Show timeline on device
            try {
                populateTimeline(0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    // Send an API request to get the timeline json
    // Fill the listview by creating the tweet object from the json
    public void populateTimeline(int page) throws JSONException {
        if (Constants.SCAFFOLD_DATA) {
            AssetsClass assets = new AssetsClass(getActivity());
            JSONArray json = assets.loadJSONFromAsset("mentions");

            // Playing with DB
            Log.d(Constants.DEBUG_KEY, String.valueOf(Tweet.dbGetCountOfTweets()));
            Tweet.dbDeleteTweets();
            Log.d(Constants.DEBUG_KEY, String.valueOf(Tweet.dbGetCountOfTweets()));

            // Since we are the fragment we can call the method directly on our self
            addAll(Tweet.fromJSONArray(json));

            // Progress bar be gone, we are done loading
            ProgressBar pbGoogleStyle = (ProgressBar) getActivity().findViewById(R.id.google_progress);
            pbGoogleStyle.setVisibility(View.GONE);
        } else {
            client.getMentionsTimeline(new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray json) {
                    Log.d(Constants.DEBUG_KEY, json.toString());
                    addAll(Tweet.fromJSONArray(json));

                    // Progress bar be gone, we are done loading
                    ProgressBar pbGoogleStyle = (ProgressBar) getActivity().findViewById(R.id.google_progress);
                    pbGoogleStyle.setVisibility(View.GONE);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                    Log.d(Constants.DEBUG_KEY, errorResponse.toString());
                }
            });
        }
    }
}

package com.purpleblue.apps.twitterclient.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.purpleblue.apps.twitterclient.Constants;
import com.purpleblue.apps.twitterclient.R;
import com.purpleblue.apps.twitterclient.TwitterApplication;
import com.purpleblue.apps.twitterclient.models.Tweet;
import com.purpleblue.apps.twitterclient.net.NetworkClass;
import com.purpleblue.apps.twitterclient.net.TwitterClient;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by ernest on 8/14/16.
 */
public class SearchTimelineFragment extends TweetsListFragment {

    private TwitterClient client;

    public static SearchTimelineFragment newInstance (String query, String resultType) {
        SearchTimelineFragment searchTimelineFragment = new SearchTimelineFragment();

        Bundle args = new Bundle();
        args.putString("query", query);
        args.putString("result_type", resultType);
        searchTimelineFragment.setArguments(args);

        return searchTimelineFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!NetworkClass.isNetworkAvailable(getActivity()) && !NetworkClass.isInternetConnected()) {
            //Toast.makeText(this, "Internet appears to be down. This app needs internet to function.", Toast.LENGTH_SHORT).show();
            Snackbar.make(getActivity().findViewById(R.id.content), "Internet appears to be down. This app needs internet to function.", Snackbar.LENGTH_LONG).
                    setAction("Action", null).show();
        } else {
            // Show timeline on device
            try {
                populateTimeline(getArguments().getString("query"), getArguments().getString("result_type"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    // Send an API request to get the timeline json
    // Fill the listview by creating the tweet object from the json
    public void populateTimeline(String query, String resultType) throws JSONException {
        // Get the client using Singleton client
        client = TwitterApplication.getRestClient(); // singleton client
        // resulType = mixed, recent, popular
        client.searchTweets(query, resultType, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject json) {
                //Log.d(String.format("%s ok1", Constants.DEBUG_KEY), json.toString());
                //Log.d(Constants.DEBUG_KEY, json.toString());
                try {
                    addAll(Tweet.fromJSONArray(json.getJSONArray("statuses")));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                // Progress bar be gone, we are done loading
                ProgressBar pbGoogleStyle = (ProgressBar) getActivity().findViewById(R.id.google_progress);
                pbGoogleStyle.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.d(String.format("%s error1", Constants.DEBUG_KEY), errorResponse.toString());
            }
        });
    }
}

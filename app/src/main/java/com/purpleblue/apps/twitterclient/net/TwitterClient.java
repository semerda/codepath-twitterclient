package com.purpleblue.apps.twitterclient.net;

import android.content.Context;
import android.util.Log;

import com.codepath.oauth.OAuthBaseClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.purpleblue.apps.twitterclient.Constants;

import org.scribe.builder.api.Api;
import org.scribe.builder.api.TwitterApi;

/*
 * 
 * This is the object responsible for communicating with a REST API. 
 * Specify the constants below to change the API being communicated with.
 * See a full list of supported API classes: 
 *   https://github.com/fernandezpablo85/scribe-java/tree/master/src/main/java/org/scribe/builder/api
 * Key and Secret are provided by the developer site for the given API i.e dev.twitter.com
 * Add methods for each relevant endpoint in the API.
 * 
 * NOTE: You may want to rename this object based on the service i.e TwitterClient or FlickrClient
 * 
 */
public class TwitterClient extends OAuthBaseClient {

	public static final Class<? extends Api> REST_API_CLASS = TwitterApi.class; // Change this
	public static final String REST_URL = "https://api.twitter.com/1.1"; // Change this, base API URL
	public static final String REST_CONSUMER_KEY = "STHDRqJx3Q8HDCSZNc4irQoN5";       // Change this
	public static final String REST_CONSUMER_SECRET = "CytArPIjDE8ef9nXO3RWFMXd12pn2oHUsHUvLAlRMDn1zKuiJd"; // Change this
	public static final String REST_CALLBACK_URL = "oauth://cpsimpletwitterclient"; // Change this (here and in manifest)

	public TwitterClient(Context context) {
		super(context, REST_API_CLASS, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET, REST_CALLBACK_URL);
	}

    // HomeTimeLine - Gets us the home timeline
    // GET statuses/home_timeline.json
    //      count=25
    //      since_id=1 (most recent tweets)
    public void getHomeTimeline(int page, AsyncHttpResponseHandler handler) {
        // [] = JSONArray (ROOT)
        // {} = JSONObject
        // https://dev.twitter.com/rest/reference/get/statuses/home_timeline
        String apiUrl = getApiUrl("statuses/home_timeline.json");
        Log.d(String.format("%s API.getHomeTimeline", Constants.DEBUG_KEY), apiUrl);
        // Specify the params
        RequestParams params = new RequestParams();
        params.put("count", "25");
        params.put("since_id", "1");
        // Execute the request
        getClient().get(apiUrl, params, handler);
    }

    // ComposeTweet
    public void composeTweet(String status, AsyncHttpResponseHandler handler) {
        // {} = JSONObject (ROOT)
        // https://dev.twitter.com/rest/reference/post/statuses/update
        // Eg. https://api.twitter.com/1.1/statuses/update.json?status=ABC
        String apiUrl = getApiUrl("statuses/update.json");
        Log.d(String.format("%s API.composeTweet", Constants.DEBUG_KEY), apiUrl);
        // Specify the params
        RequestParams params = new RequestParams();
        params.put("status", status);
        // Execute the request
        getClient().post(apiUrl, params, handler);
    }

    // ****************************************************
    // Get Logged in User Account
    public void getUserInfo(String screenName, AsyncHttpResponseHandler handler) {
        // {} = JSONObject (ROOT)
        // https://dev.twitter.com/rest/reference/get/account/verify_credentials

        if (screenName == null) {
            // https://api.twitter.com/1.1/account/verify_credentials.json
            String apiUrl = getApiUrl("account/verify_credentials.json");
            Log.d(String.format("%s API.getUserInfo", Constants.DEBUG_KEY), apiUrl);
            // Execute the request
            getClient().get(apiUrl, null, handler);
        } else {
            // https://dev.twitter.com/rest/reference/get/users/show
            String apiUrl = getApiUrl("users/show.json");
            Log.d(String.format("%s API.getUserInfo", Constants.DEBUG_KEY), apiUrl);
            // Specify the params
            RequestParams params = new RequestParams();
            params.put("screen_name", screenName);
            // Execute the request
            getClient().get(apiUrl, params, handler);
        }
    }
    // ****************************************************

    public void retweetStatus(long tweetId, AsyncHttpResponseHandler handler) {
        // https://dev.twitter.com/rest/reference/post/statuses/retweet/%3Aid
        String apiUrl = getApiUrl(String.format("statuses/retweet/%s.json", tweetId));
        Log.d(String.format("%s API.retweetStatus", Constants.DEBUG_KEY), apiUrl);
        // Specify the params
        RequestParams params = new RequestParams();
        params.put("id", tweetId);
        // Execute the request
        getClient().post(apiUrl, params, handler);
    }

    public void favoriteStatus(long tweetId, AsyncHttpResponseHandler handler) {
        // https://dev.twitter.com/rest/reference/post/favorites/create
        String apiUrl = getApiUrl(String.format("favorites/create.json?id=%s", tweetId));
        Log.d(String.format("%s API.favoriteStatus", Constants.DEBUG_KEY), apiUrl);
        // Specify the params
        RequestParams params = new RequestParams();
        params.put("id", tweetId);
        // Execute the request
        getClient().post(apiUrl, params, handler);
    }

    public void getMentionsTimeline(JsonHttpResponseHandler handler) {
        // [] = JSONArray (ROOT)
        // {} = JSONObject
        // https://dev.twitter.com/rest/reference/get/statuses/mentions_timeline
        String apiUrl = getApiUrl("statuses/mentions_timeline.json");
        Log.d(String.format("%s API.getMentionsTimeline", Constants.DEBUG_KEY), apiUrl);
        // Specify the params
        RequestParams params = new RequestParams();
        params.put("count", "25");
        // Execute the request
        getClient().get(apiUrl, params, handler);
    }

    public void getUserTimeline(String screenName, JsonHttpResponseHandler handler) {
        // [] = JSONArray (ROOT)
        // {} = JSONObject
        // https://dev.twitter.com/rest/reference/get/statuses/user_timeline
        String apiUrl = getApiUrl("statuses/user_timeline.json");
        Log.d(String.format("%s API.getUserTimeline", Constants.DEBUG_KEY), apiUrl);
        // Specify the params
        RequestParams params = new RequestParams();
        params.put("count", "25");
        params.put("screen_name", screenName);
        // Execute the request
        getClient().get(apiUrl, params, handler);
    }

    public void getFollowersList(String screenName, JsonHttpResponseHandler handler) {
        // {} = JSONObject (ROOT)
        // https://dev.twitter.com/rest/reference/get/followers/list
        String apiUrl = getApiUrl("followers/list.json");
        Log.d(String.format("%s API.getFollowersList", Constants.DEBUG_KEY), apiUrl);
        // Specify the params
        RequestParams params = new RequestParams();
        params.put("count", "25");
        params.put("screen_name", screenName);
        // Execute the request
        getClient().get(apiUrl, params, handler);
    }

    public void getFriendsList(String screenName, JsonHttpResponseHandler handler) {
        // {} = JSONObject (ROOT)
        // https://dev.twitter.com/rest/reference/get/friends/list
        String apiUrl = getApiUrl("friends/list.json");
        Log.d(String.format("%s API.getFriendsList", Constants.DEBUG_KEY), apiUrl);
        // Specify the params
        RequestParams params = new RequestParams();
        params.put("count", "25");
        params.put("screen_name", screenName);
        // Execute the request
        getClient().get(apiUrl, params, handler);
    }

    public void getProfileBanner(String screenName, JsonHttpResponseHandler handler) {
        // {} = JSONObject (ROOT)
        // https://dev.twitter.com/rest/reference/get/users/profile_banner
        String apiUrl = getApiUrl("users/profile_banner.json");
        Log.d(String.format("%s API.getProfileBanner", Constants.DEBUG_KEY), apiUrl);
        Log.d(String.format("%s API.getProfileBanner.screenName", Constants.DEBUG_KEY), screenName);
        // Specify the params
        RequestParams params = new RequestParams();
        params.put("screen_name", screenName);
        // Execute the request
        getClient().get(apiUrl, params, handler);
    }

    public void searchTweets(String query, String resultType, JsonHttpResponseHandler handler) {
        // [] = JSONArray (ROOT)
        // {} = JSONObject
        // https://dev.twitter.com/rest/reference/get/search/tweets
        String apiUrl = getApiUrl("search/tweets.json");
        Log.d(String.format("%s API.searchTweets", Constants.DEBUG_KEY), apiUrl);
        Log.d(String.format("%s API.searchTweets.query", Constants.DEBUG_KEY), query);
        Log.d(String.format("%s API.searchTweets.result_type", Constants.DEBUG_KEY), resultType);
        // Specify the params
        RequestParams params = new RequestParams();
        params.put("q", query);
        //params.put("geocode", "37.781157,-122.398720,1mi"); // latitude,longitude,radius
        params.put("result_type", resultType); // mixed, recent, popular
        // Execute the request
        getClient().get(apiUrl, params, handler);
    }

	/* 1. Define the endpoint URL with getApiUrl and pass a relative path to the endpoint
	 * 	  i.e getApiUrl("statuses/home_timeline.json");
	 * 2. Define the parameters to pass to the request (query or body)
	 *    i.e RequestParams params = new RequestParams("foo", "bar");
	 * 3. Define the request method and make a call to the client
	 *    i.e client.get(apiUrl, params, handler);
	 *    i.e client.post(apiUrl, params, handler);
	 */
}
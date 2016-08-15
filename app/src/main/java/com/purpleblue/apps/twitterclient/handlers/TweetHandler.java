package com.purpleblue.apps.twitterclient.handlers;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.purpleblue.apps.twitterclient.Constants;
import com.purpleblue.apps.twitterclient.R;
import com.purpleblue.apps.twitterclient.TwitterApplication;
import com.purpleblue.apps.twitterclient.activities.ProfileActivity;
import com.purpleblue.apps.twitterclient.fragments.ComposeTweetDialogFragment;
import com.purpleblue.apps.twitterclient.fragments.DetailTweetDialogFragment;
import com.purpleblue.apps.twitterclient.models.Tweet;
import com.purpleblue.apps.twitterclient.models.User;
import com.purpleblue.apps.twitterclient.net.TwitterClient;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by ernest on 8/7/16.
 *
 * Note on passing arguments from data binding in XML
 * http://stackoverflow.com/questions/37105066/android-data-binding-pass-arguments-to-onclick-method
 *
 * Using the RecyclerView is different (easy peasy)
 * http://guides.codepath.com/android/Using-the-RecyclerView#simple-click-handler-within-viewholder
 *
 * Context in FragmentManager
 * http://stackoverflow.com/questions/10689997/fragmentmanager-from-context
 *
 */
public class TweetHandler {

    private Context mContext;

    public TweetHandler(Context context) {
        mContext = context;
    }

    // Tweets

    public void onClickTweetReply(View view, Tweet tweet) {
        view.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.anim_item));
        //Log.d("DEBUG", "TweetHandlers >> Reply");
        //Log.d("DEBUG", "TweetHandlers >> Reply: " + tweet.toString());

        FragmentManager fm = ((FragmentActivity) mContext).getSupportFragmentManager();
        ComposeTweetDialogFragment composeTweetDialogFragment = ComposeTweetDialogFragment.newInstance("", tweet);
        composeTweetDialogFragment.show(fm, "fragment_compose_tweet");
    }

    public void onClickTweetRetweet(View view, Tweet tweet) {
        view.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.anim_item));
        //Log.d("DEBUG", "TweetHandlers >> Retweet");
        //Log.d("DEBUG", "TweetHandlers >> Retweet: " + tweet.toString());

        TwitterClient client = TwitterApplication.getRestClient();
        client.retweetStatus(tweet.getTweetId(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject json) {
                //Log.d("DEBUG", json.toString());

                Toast.makeText(mContext, "Tweet Retweeted.", Toast.LENGTH_SHORT).show();

                // Refresh parent activity -- TODO: probably better to update inline than refresh
                //TimelineActivity callingActivity = (TimelineActivity) mContext;
                //callingActivity.sendRefreshRequest();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.d("DEBUG", errorResponse.toString());
            }
        });
    }

    public void onClickTweetFavorite(View view, Tweet tweet) {
        view.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.anim_item));
        //view.setBackgroundColor(Color.RED);

        //Log.d("DEBUG", "TweetHandlers >> Favorite");
        //Log.d("DEBUG", "TweetHandlers >> Favorite: " + tweet.toString());

        TwitterClient client = TwitterApplication.getRestClient();
        client.favoriteStatus(tweet.getTweetId(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject json) {
                //Log.d("DEBUG", json.toString());

                Toast.makeText(mContext, "Tweet Favorited.", Toast.LENGTH_SHORT).show();

                // Refresh parent activity -- TODO: probably better to update inline than refresh
                //TimelineActivity callingActivity = (TimelineActivity) mContext;
                //callingActivity.sendRefreshRequest();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.d("DEBUG", errorResponse.toString());
            }
        });
    }

    public void onClickTweetShowDetail(View view, Tweet tweet) {
        view.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.anim_item));
        //Log.d("DEBUG", "TweetHandlers >> ShowDetail");
        //Log.d("DEBUG", "TweetHandlers >> ShowDetail: " + tweet.toString());

        FragmentManager fm = ((FragmentActivity) mContext).getSupportFragmentManager();
        DetailTweetDialogFragment detailTweetDialogFragment = DetailTweetDialogFragment.newInstance("", tweet);
        detailTweetDialogFragment.show(fm, "fragment_detail_tweet");
    }

    // Used from XML data binding onClick
    // TODO: Expire this function
    public void onClickTweetShowProfile(View view, Tweet tweet) {
        view.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.anim_item));
        //Log.d("DEBUG", "TweetHandlers >> ShowDetail");
        //Log.d("DEBUG", "TweetHandlers >> ShowDetail: " + tweet.toString());
        Intent i = new Intent(mContext, ProfileActivity.class);
        i.putExtra("tweet", tweet);
        mContext.startActivity(i);
    }

    // Used from Tweet Body via PatternEditableBuilder
    public void onClickTweetShowProfile(View view, String screenName) {
        view.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.anim_item));
        //Log.d("DEBUG", "TweetHandlers >> ShowDetail");
        //Log.d("DEBUG", "TweetHandlers >> ShowDetail: " + screenName);
        Intent i = new Intent(mContext, ProfileActivity.class);
        i.putExtra("screen_name", screenName);
        mContext.startActivity(i);
    }

    // User Profile
    public void onClickShowFollowers(View view, User user) {
        Log.d(Constants.DEBUG_KEY, "TweetHandlers >> onClickTweetShowFollowers: " + user.toString());
    }

    public void onClickShowFollowing(View view, User user) {
        Log.d(Constants.DEBUG_KEY, "TweetHandlers >> onClickTweetShowFollowers: " + user.toString());
    }

}
package com.purpleblue.apps.twitterclient.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.jpardogo.android.googleprogressbar.library.FoldingCirclesDrawable;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.purpleblue.apps.twitterclient.AssetsClass;
import com.purpleblue.apps.twitterclient.Constants;
import com.purpleblue.apps.twitterclient.R;
import com.purpleblue.apps.twitterclient.TwitterApplication;
import com.purpleblue.apps.twitterclient.adapters.ProfilePagerAdapter;
import com.purpleblue.apps.twitterclient.models.Tweet;
import com.purpleblue.apps.twitterclient.models.User;
import com.purpleblue.apps.twitterclient.net.NetworkClass;
import com.purpleblue.apps.twitterclient.net.TwitterClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;

public class ProfileActivity extends AppCompatActivity {

    TwitterClient client;
    User user;

    @BindView(R.id.ivProfileBannerImage)
    ImageView ivProfileBannerImage;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    @BindView(R.id.google_progress)
    ProgressBar mProgressBar;

    @BindView(R.id.tvFullName)
    TextView tvFullName;
    @BindView(R.id.tvTagline)
    TextView tvTagline;
    @BindView(R.id.tvFollowers)
    TextView tvFollowers;
    @BindView(R.id.tvFollowing)
    TextView tvFollowing;
    @BindView(R.id.ivProfileImage)
    ImageView ivProfileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ButterKnife.bind(this);
        //ButterKnife.setDebug(true);

        // Load Google progress circle
        mProgressBar.setIndeterminateDrawable(new FoldingCirclesDrawable.Builder(this).build());

        String screenName = ""; // without @

        // Primary nav
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        // If Intent is sending a User (non my account)
        Tweet tweet = (Tweet) getIntent().getParcelableExtra("tweet");
        if (tweet == null) {
            try {
                screenName = getIntent().getStringExtra("screen_name");
                Log.d(String.format("%s ProfileActivity.screenName", Constants.DEBUG_KEY), screenName.toString());
                loadProfileHeaderData(screenName);
                loadProfileBanner(screenName);
                loadProfileBody(screenName);
                //loadUserTimelineFragment(savedInstanceState, screenName);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } else {
            try {
                Log.d(String.format("%s ProfileActivity.tweet", Constants.DEBUG_KEY), tweet.getUser().toString());
                user = tweet.getUser();
                screenName = user.getScreenName();
                getSupportActionBar().setTitle(user.getPrefixedScreenName());
                loadProfileHeaderData(null);
                loadProfileBanner(screenName);
                loadProfileBody(screenName);
                //loadUserTimelineFragment(savedInstanceState, screenName);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadProfileBody(String screenName) {
        // PagerSlidingTabStrip
        // http://guides.codepath.com/android/Sliding-Tabs-with-PagerSlidingTabStrip
        // Get the viewpager
        ViewPager vpPager = (ViewPager) findViewById(R.id.viewpager);
        // Set the viewpager adapter for the pager
        vpPager.setAdapter(new ProfilePagerAdapter(getSupportFragmentManager(), screenName));
        // Find the sliding tabstrip
        PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        // Attach the tabstrip to the viewpager
        tabStrip.setViewPager(vpPager);
    }

    /*
    private void loadUserTimelineFragment(Bundle savedInstanceState, String screenName) {
        // As before, we don't want to call this if its already created/in memory
        if (savedInstanceState == null) {
            UserTimelineFragment fragmentUserTimeline = UserTimelineFragment.newInstance(screenName);
            // Display user fragment within this activity (dynamically)
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction(); // I want to change fragment dynamically
            ft.replace(R.id.flContainer, fragmentUserTimeline);
            ft.commit(); // changes the fragments
        }
    }
    */

    private void loadProfileHeaderData(String screenName) throws JSONException {
        client = TwitterApplication.getRestClient();
        if (!NetworkClass.isNetworkAvailable(this) && !NetworkClass.isInternetConnected()) {
            //Toast.makeText(this, "Internet appears to be down. This app needs internet to function.", Toast.LENGTH_SHORT).show();
            Snackbar.make(this.findViewById(R.id.content), "Internet appears to be down. This app needs internet to function.", Snackbar.LENGTH_LONG).
                    setAction("Action", null).show();
        } else {
            if (Constants.SCAFFOLD_DATA) {
                AssetsClass assets = new AssetsClass(this);
                JSONObject json = assets.loadJSONObjectFromAsset("profile");
                user = User.fromJSON(json);

                populateProfileHeader(user);

                // My current user account's information
                //getSupportActionBar().setTitle(user.getPrefixedScreenName());
                toolbarTitle.setText(user.getPrefixedScreenName());

                // Now we call setRefreshing(false) to signal refresh has finished
                //swipeContainer.setRefreshing(false);
            } else {
                // Get the account info
                client.getUserInfo(screenName, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        Log.d(Constants.DEBUG_KEY, response.toString());

                        user = User.fromJSON(response);
                        // My current user account's information
                        //getSupportActionBar().setTitle(user.getPrefixedScreenName());
                        toolbarTitle.setText(user.getPrefixedScreenName());

                        populateProfileHeader(user);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Log.d(Constants.DEBUG_KEY, throwable.toString());
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                        Log.d(Constants.DEBUG_KEY, errorResponse.toString());
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        Log.d(Constants.DEBUG_KEY, errorResponse.toString());
                    }
                });
            }
        }
    }

    private void populateProfileHeader(User user) {
        tvFullName.setText(user.getName());
        tvTagline.setText(user.getTagLine());
        tvFollowers.setText(String.format("%s %s", user.getFollowersCountFormatted(), getString(R.string.followers)));
        tvFollowing.setText(String.format("%s %s", user.getFriendsCountFormatted(), getString(R.string.friends)));

        Glide.with(this)
                .load(user.getProfileImageUrl())
                .asBitmap()
                //.override(300, 300) // resizes the image to these dimensions (in pixel)
                .centerCrop() // this cropping technique scales the image so that it fills the requested bounds and then crops the extra.
                .placeholder(R.drawable.ic_autorenew_black_48dp)
                .error(R.drawable.ic_block_red_48dp)
                .into(new BitmapImageViewTarget(ivProfileImage) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(getResources(), resource);
                        circularBitmapDrawable.setCornerRadius(24);
                        ivProfileImage.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    private void loadProfileBanner(String screenName) throws JSONException {
        client = TwitterApplication.getRestClient();
        if (!NetworkClass.isNetworkAvailable(this) && !NetworkClass.isInternetConnected()) {
            //Toast.makeText(this, "Internet appears to be down. This app needs internet to function.", Toast.LENGTH_SHORT).show();
            Snackbar.make(this.findViewById(R.id.content), "Internet appears to be down. This app needs internet to function.", Snackbar.LENGTH_LONG).
                    setAction("Action", null).show();
        } else {
            client.getProfileBanner(screenName, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    Log.d(String.format("%s loadProfileBanner.onSuccess", Constants.DEBUG_KEY), response.toString());
                    try {
                        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

                        JSONObject bannerSizes = response.getJSONObject("sizes");
                        String bannerUrl = bannerSizes.getJSONObject("mobile").getString("url");

                        Glide.with(ProfileActivity.this)
                                .load(bannerUrl)
                                //.centerCrop() // this cropping technique scales the image so that it fills the requested bounds and then crops the extra.
                                .placeholder(R.drawable.ic_autorenew_black_48dp)
                                .error(R.drawable.ic_block_red_48dp)
                                .into(ivProfileBannerImage);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                    Log.d(String.format("%s loadProfileBanner.onFailure", Constants.DEBUG_KEY), errorResponse.toString());
                }
            });
        }
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate menu resource file.
        getMenuInflater().inflate(R.menu.menu_share, menu);
        // Locate MenuItem with ShareActionProvider
        MenuItem item = menu.findItem(R.id.menu_item_share);
        // Fetch reference to the share action provider
        ShareActionProvider miShareAction = (ShareActionProvider) MenuItemCompat.getActionProvider(item);

        // Attach Share for a WebView URL
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");

        // pass in the URL currently being used by the WebView
        //shareIntent.putExtra(Intent.EXTRA_TEXT, article.getWebUrl());
        //shareIntent.putExtra(Intent.EXTRA_SUBJECT, article.getHeadline());

        miShareAction.setShareIntent(shareIntent);

        return super.onCreateOptionsMenu(menu);
    }
*/

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}

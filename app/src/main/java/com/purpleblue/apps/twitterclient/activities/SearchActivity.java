package com.purpleblue.apps.twitterclient.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.astuetz.PagerSlidingTabStrip;
import com.jpardogo.android.googleprogressbar.library.FoldingCirclesDrawable;
import com.purpleblue.apps.twitterclient.R;
import com.purpleblue.apps.twitterclient.adapters.TweetsPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ernest on 8/12/16.
 */
public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.google_progress)
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        // Load Google progress circle
        ButterKnife.bind(this);
        mProgressBar.setIndeterminateDrawable(new FoldingCirclesDrawable.Builder(this).build());

        // Primary nav
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.primary));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Intent is sending a Query
        String query = (String) getIntent().getStringExtra("query");
        getSupportActionBar().setTitle(query);

        // PagerSlidingTabStrip
        // http://guides.codepath.com/android/Sliding-Tabs-with-PagerSlidingTabStrip
        // Get the viewpager
        ViewPager vpPager = (ViewPager) findViewById(R.id.viewpager);
        // Set the viewpager adapter for the pager
        vpPager.setAdapter(new TweetsPagerAdapter(getSupportFragmentManager(), query));
        // Find the sliding tabstrip
        PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        // Attach the tabstrip to the viewpager
        tabStrip.setViewPager(vpPager);
    }

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

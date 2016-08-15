package com.purpleblue.apps.twitterclient.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.jpardogo.android.googleprogressbar.library.FoldingCirclesDrawable;
import com.purpleblue.apps.twitterclient.R;
import com.purpleblue.apps.twitterclient.adapters.TweetsPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

// Note: the activity is just logic to load fragments onto the screen
public class TimelineActivity extends AppCompatActivity {

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
        toolbar.setLogo(R.drawable.ic_twitter);
        toolbar.setBackgroundColor(getResources().getColor(R.color.primary));
        toolbar.setTitle(R.string.BLANK);
        setSupportActionBar(toolbar);

        // PagerSlidingTabStrip
        // http://guides.codepath.com/android/Sliding-Tabs-with-PagerSlidingTabStrip
        // Get the viewpager
        ViewPager vpPager = (ViewPager) findViewById(R.id.viewpager);
        // Set the viewpager adapter for the pager
        vpPager.setAdapter(new TweetsPagerAdapter(getSupportFragmentManager(), ""));
        // Find the sliding tabstrip
        PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        // Attach the tabstrip to the viewpager
        tabStrip.setViewPager(vpPager);
    }

    public void setupView() {

        /*
        // Make sure we can click on each item to see more detail about the article
        rvTweets.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, float x, float y) {
                // Get the article to display
                Tweet tweet = tweets.get(position);
                //Log.d("DEBUG", String.valueOf(tweet));

                FragmentManager fm = getSupportFragmentManager();
                DetailTweetDialogFragment detailTweetDialogFragment = DetailTweetDialogFragment.newInstance("", tweet);
                detailTweetDialogFragment.show(fm, "fragment_detail_tweet");
            }
        }));
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_timeline, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(TimelineActivity.this, String.format("Searching '%s'", query), Toast.LENGTH_SHORT).show();

                Intent i = new Intent(TimelineActivity.this, SearchActivity.class);
                i.putExtra("query", query);
                startActivity(i);

                //searchArticlesUsingQuery(query, 0, true);

                // workaround to avoid issues with some emulators and keyboard devices firing twice if a keyboard enter is used
                // see https://code.google.com/p/android/issues/detail?id=24599
                //searchView.clearFocus();

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public void onProfileView(MenuItem mi) {
        Intent i = new Intent(this, ProfileActivity.class);
        i.putExtra("screen_name", "semerda"); // TODO: Add logged in username
        startActivity(i);
    }
}

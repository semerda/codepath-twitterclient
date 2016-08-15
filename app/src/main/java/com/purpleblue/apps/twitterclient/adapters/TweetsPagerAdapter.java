package com.purpleblue.apps.twitterclient.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.purpleblue.apps.twitterclient.fragments.HomeTimelineFragment;
import com.purpleblue.apps.twitterclient.fragments.MentionsTimelineFragment;
import com.purpleblue.apps.twitterclient.fragments.SearchTimelineFragment;
import com.purpleblue.apps.twitterclient.utils.StringUtils;

/**
 * Created by ernest on 8/10/16.
 */
// Return the order of the fragments in the view pager
public class TweetsPagerAdapter extends FragmentPagerAdapter {

    private String query;
    private boolean isHomeActivity;

    private String tabTitles[] = { "Home", "Mentions" };
    private String tabTitlesSearch[] = { "Mixed", "Recent", "Popular" };

    // Adapter gets the manager to insert or remove fragment from activity
    public TweetsPagerAdapter(FragmentManager fm, String searchQuery) {
        super(fm);

        query = searchQuery;
        isHomeActivity = StringUtils.isNullOrEmpty(query);
    }

    // The order and creation of fragments within the pager
    @Override
    public Fragment getItem(int position) {
        Fragment myFragment;
        if (isHomeActivity) {
            if (position == 0) {
                myFragment = new HomeTimelineFragment();
            } else if (position == 1) {
                myFragment = new MentionsTimelineFragment();
            } else {
                myFragment = null;
            }
        } else {
            // Must be search
            myFragment = new SearchTimelineFragment().newInstance(query, tabTitlesSearch[position].toLowerCase());
        }

        return myFragment;
    }

    // Return the tab title
    @Override
    public CharSequence getPageTitle(int position) {
        if (isHomeActivity) {
            return tabTitles[position];
        } else {
            return tabTitlesSearch[position];
        }
    }

    // How many fragments there are to swipe between?
    @Override
    public int getCount() {
        if (isHomeActivity) {
            return tabTitles.length;
        } else {
            return tabTitlesSearch.length;
        }
    }
}

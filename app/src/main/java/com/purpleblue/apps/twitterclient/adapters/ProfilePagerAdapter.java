package com.purpleblue.apps.twitterclient.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.purpleblue.apps.twitterclient.fragments.FollowersTimelineFragment;
import com.purpleblue.apps.twitterclient.fragments.FriendsTimelineFragment;
import com.purpleblue.apps.twitterclient.fragments.UserTimelineFragment;

/**
 * Created by ernest on 8/10/16.
 */
// Return the order of the fragments in the view pager
public class ProfilePagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = { "Tweets", "Followers", "Friends" };
    private String screenName;

    // Adapter gets the manager to insert or remove fragment from activity
    public ProfilePagerAdapter(FragmentManager fm, String screenName) {
        super(fm);

        this.screenName = screenName;
    }

    // The order and creation of fragments within the pager
    @Override
    public Fragment getItem(int position) {
        Fragment myFragment;

        if (position == 0) {
            myFragment = new UserTimelineFragment().newInstance(screenName);
        } else if (position == 1) {
            myFragment = new FollowersTimelineFragment().newInstance(screenName);
        } else if (position == 2) {
            myFragment = new FriendsTimelineFragment().newInstance(screenName);
        } else {
            myFragment = null;
        }

        return myFragment;
    }

    // Return the tab title
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    // How many fragments there are to swipe between?
    @Override
    public int getCount() {
        return tabTitles.length;
    }
}

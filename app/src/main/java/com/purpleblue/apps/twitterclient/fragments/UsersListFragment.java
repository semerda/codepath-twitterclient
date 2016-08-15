package com.purpleblue.apps.twitterclient.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.astuetz.PagerSlidingTabStrip;
import com.purpleblue.apps.twitterclient.R;
import com.purpleblue.apps.twitterclient.adapters.UsersAdapter;
import com.purpleblue.apps.twitterclient.models.User;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by ernest on 8/9/16.
 */
public class UsersListFragment extends Fragment {

    private ArrayList<User> lUsers;
    private UsersAdapter aUsers;
    private RecyclerView rvUsers;
    Integer start_index;

    // Creation lifecycle event
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the arraylist (data source)
        lUsers = new ArrayList<>();
        start_index = lUsers.size();

        // Construct the adapter from data source
        aUsers = new UsersAdapter(getActivity(), lUsers);
    }

    // Inflation logic
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users_list, parent, false);

        // Connect adapter to list view
        rvUsers = (RecyclerView) view.findViewById(R.id.rvUsers);

        // Connect adapter to list view
        rvUsers.setAdapter(aUsers);
        // Set layout manager to position the items
        rvUsers.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvUsers.setItemAnimator(new SlideInUpAnimator());
        // http://guides.codepath.com/android/Using-the-RecyclerView#performance
        //rvTweets.setHasFixedSize(true);

        return view;
    }

    private void hideViews() {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.animate().translationY(-300).setInterpolator(new AccelerateInterpolator(2));

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) getActivity().findViewById(R.id.tabs);
        tabs.animate().translationY(-300).setInterpolator(new AccelerateInterpolator(2));
    }

    private void showViews() {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) getActivity().findViewById(R.id.tabs);
        tabs.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
    }

    public UsersAdapter getAdapter() { return aUsers; };

    public RecyclerView getRecyclerView() { return rvUsers; };

    public void addAll(List<User> users) {
        lUsers.addAll(users);
        aUsers.notifyItemRangeInserted(start_index, lUsers.size());
    }

    public void clearAdapterData() {
        // Clear the existing list
        aUsers.clearData();
    }
}

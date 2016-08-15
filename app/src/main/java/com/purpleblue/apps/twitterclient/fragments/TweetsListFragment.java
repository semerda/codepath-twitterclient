package com.purpleblue.apps.twitterclient.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import com.purpleblue.apps.twitterclient.adapters.TweetsAdapter;
import com.purpleblue.apps.twitterclient.models.Tweet;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by ernest on 8/9/16.
 */
public class TweetsListFragment extends Fragment {

    private ArrayList<Tweet> lTweets;
    private TweetsAdapter aTweets;
    private RecyclerView rvTweets;
    Integer start_index;

    // Creation lifecycle event
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the arraylist (data source)
        lTweets = new ArrayList<>();
        start_index = lTweets.size();

        // Construct the adapter from data source
        aTweets = new TweetsAdapter(getActivity(), lTweets);
    }

    // Inflation logic
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tweets_list, parent, false);

        // Connect adapter to list view
        rvTweets = (RecyclerView) view.findViewById(R.id.rvTweets);

        // Connect adapter to list view
        rvTweets.setAdapter(aTweets);
        // Set layout manager to position the items
        rvTweets.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvTweets.setItemAnimator(new SlideInUpAnimator());
        // http://guides.codepath.com/android/Using-the-RecyclerView#performance
        //rvTweets.setHasFixedSize(true);

        /*
        // On Scroll hide Header/ActionBar
        rvTweets.setOnScrollListener(new HidingScrollListener() {
            @Override
            public void onHide() {
                hideViews();
            }
            @Override
            public void onShow() {
                showViews();
            }
        });
        */

        // Compose a Tweet
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fabComposeTweet);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                ComposeTweetDialogFragment composeTweetDialogFragment = ComposeTweetDialogFragment.newInstance(getString(R.string.compose_a_tweet), null);
                composeTweetDialogFragment.show(fm, "fragment_compose_tweet");
            }
        });

        return view;
    }

    private void hideViews() {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.animate().translationY(-300).setInterpolator(new AccelerateInterpolator(2));

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) getActivity().findViewById(R.id.tabs);
        tabs.animate().translationY(-300).setInterpolator(new AccelerateInterpolator(2));

        /*
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mFabButton.getLayoutParams();
        int fabBottomMargin = lp.bottomMargin;
        mFabButton.animate().translationY(mFabButton.getHeight()+fabBottomMargin).setInterpolator(new AccelerateInterpolator(2)).start();
        */
    }

    private void showViews() {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) getActivity().findViewById(R.id.tabs);
        tabs.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));

        //mFabButton.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
    }

    public TweetsAdapter getAdapter() { return aTweets; };

    public RecyclerView getRecyclerView() { return rvTweets; };

    public void addAll(List<Tweet> tweets) {
        //Log.d(Constants.DEBUG_KEY, tweets.toString());

        lTweets.addAll(tweets);
        aTweets.notifyItemRangeInserted(start_index, lTweets.size());

        // Now we call setRefreshing(false) to signal refresh has finished
        //---swipeContainer.setRefreshing(false);
    }

    public void clearAdapterData() {
        // Clear the existing list
        aTweets.clearData();
    }
}

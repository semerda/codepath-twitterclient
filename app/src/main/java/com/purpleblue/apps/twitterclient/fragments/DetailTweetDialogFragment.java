package com.purpleblue.apps.twitterclient.fragments;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.purpleblue.apps.twitterclient.TimeClass;
import com.purpleblue.apps.twitterclient.TwitterApplication;
import com.purpleblue.apps.twitterclient.models.Tweet;
import com.purpleblue.apps.twitterclient.net.TwitterClient;

import java.text.ParseException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by ernest on 8/6/16.
 */
public class DetailTweetDialogFragment extends DialogFragment {

    Tweet tweet;
    TwitterClient client = TwitterApplication.getRestClient();

    // Ref: https://github.com/codepath/android_guides/wiki/Working-with-the-EditText
    @BindView(com.purpleblue.apps.twitterclient.R.id.btnClose)
    Button btnClose;

    @BindView(com.purpleblue.apps.twitterclient.R.id.tvTweetUserName)
    TextView tvTweetUserName;
    @BindView(com.purpleblue.apps.twitterclient.R.id.tvTweetScreenName)
    TextView tvTweetScreenName;
    @BindView(com.purpleblue.apps.twitterclient.R.id.tvTweetCreatedAt)
    TextView tvTweetCreatedAt;

    @BindView(com.purpleblue.apps.twitterclient.R.id.ivTweetProfileImage)
    ImageView ivTweetProfileImage;

    @BindView(com.purpleblue.apps.twitterclient.R.id.tvTweetBody)
    TextView tvTweetBody;
    @BindView(com.purpleblue.apps.twitterclient.R.id.ivTweetMedia)
    ImageView ivTweetMedia;

    private Unbinder unbinder;

    public DetailTweetDialogFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static DetailTweetDialogFragment newInstance(String title, Tweet tweet) {
        DetailTweetDialogFragment frag = new DetailTweetDialogFragment();

        Bundle args = new Bundle();
        args.putString("title", title);

        // Tweet
        args.putString("body", tweet.getBody());
        args.putString("userName", tweet.getUser().getName());
        args.putString("screenName", tweet.getUser().getScreenName());
        args.putString("profileImageUrl", tweet.getUser().getProfileImageUrl());
        args.putString("createdAt", tweet.getCreatedAt());
        args.putString("mediaUrl", tweet.getMediaUrl());

        frag.setArguments(args);

        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE, 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(com.purpleblue.apps.twitterclient.R.layout.content_detail_tweet, container);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        final Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().getAttributes().windowAnimations = com.purpleblue.apps.twitterclient.R.style.MyDialogAnimation_Window;
        return dialog;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvTweetUserName.setText("\n\n" + getArguments().getString("userName"));
        tvTweetScreenName.setText("@" + getArguments().getString("screenName"));

        String createdAt = getArguments().getString("createdAt");
        String timeAgoString = "Not Available";
        if (createdAt != null) {
            try {
                TimeClass timeClass = new TimeClass();
                timeAgoString = timeClass.getTimeAgoUsingStringDate(createdAt, "", view.getContext());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        tvTweetCreatedAt.setText(timeAgoString);

        Glide.with(view.getContext())
                .load(getArguments().getString("profileImageUrl"))
                .asBitmap()
                .centerCrop()
                .placeholder(com.purpleblue.apps.twitterclient.R.drawable.ic_autorenew_black_48dp)
                .error(com.purpleblue.apps.twitterclient.R.drawable.ic_block_red_48dp)
                .into(new BitmapImageViewTarget(ivTweetProfileImage) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(view.getContext().getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        ivTweetProfileImage.setImageDrawable(circularBitmapDrawable);
                    }
                });

        tvTweetBody.setText(getArguments().getString("body"));

        Glide.with(view.getContext())
                .load(getArguments().getString("mediaUrl"))
                .asBitmap()
                .centerCrop()
                .placeholder(com.purpleblue.apps.twitterclient.R.drawable.ic_autorenew_black_48dp)
                .error(com.purpleblue.apps.twitterclient.R.drawable.ic_block_red_48dp)
                .into(ivTweetMedia);

        //Log.d("DEBUG", getArguments().getString("body"));

        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @OnClick(com.purpleblue.apps.twitterclient.R.id.btnClose)
    public void onClickClose(Button button) {
        getDialog().dismiss();
    }

    // When binding a fragment in onCreateView, set the views to null in onDestroyView.
    // ButterKnife returns an Unbinder on the initial binding that has an unbind method to do this automatically.
    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}

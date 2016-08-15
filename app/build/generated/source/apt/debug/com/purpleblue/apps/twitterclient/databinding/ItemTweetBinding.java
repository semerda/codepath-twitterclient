package com.purpleblue.apps.twitterclient.databinding;
import com.purpleblue.apps.twitterclient.R;
import com.purpleblue.apps.twitterclient.BR;
import android.view.View;
public class ItemTweetBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnClickListener.Listener {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.llTweetActions, 12);
        sViewsWithIds.put(R.id.ivDivider, 13);
    }
    // views
    public final android.widget.ImageView ivDivider;
    public final android.widget.ImageView ivFavoriteCount;
    public final android.widget.ImageView ivProfileImage;
    public final android.widget.ImageView ivReply;
    public final android.widget.ImageView ivRetweetCount;
    public final android.widget.LinearLayout llTweetActions;
    private final android.widget.RelativeLayout mboundView0;
    public final android.widget.TextView tvBody;
    public final android.widget.TextView tvFavoriteCount;
    public final android.widget.TextView tvMoreDetail;
    public final android.widget.TextView tvRetweetCount;
    public final android.widget.TextView tvScreenName;
    public final android.widget.TextView tvTimeAgo;
    public final android.widget.TextView tvUserName;
    // variables
    private com.purpleblue.apps.twitterclient.handlers.TweetHandler mHandler;
    private com.purpleblue.apps.twitterclient.models.Tweet mTweet;
    private final android.view.View.OnClickListener mCallback11;
    private final android.view.View.OnClickListener mCallback10;
    private final android.view.View.OnClickListener mCallback4;
    private final android.view.View.OnClickListener mCallback3;
    private final android.view.View.OnClickListener mCallback9;
    private final android.view.View.OnClickListener mCallback8;
    private final android.view.View.OnClickListener mCallback7;
    private final android.view.View.OnClickListener mCallback6;
    private final android.view.View.OnClickListener mCallback5;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemTweetBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds);
        this.ivDivider = (android.widget.ImageView) bindings[13];
        this.ivFavoriteCount = (android.widget.ImageView) bindings[9];
        this.ivFavoriteCount.setTag(null);
        this.ivProfileImage = (android.widget.ImageView) bindings[1];
        this.ivProfileImage.setTag(null);
        this.ivReply = (android.widget.ImageView) bindings[6];
        this.ivReply.setTag(null);
        this.ivRetweetCount = (android.widget.ImageView) bindings[7];
        this.ivRetweetCount.setTag(null);
        this.llTweetActions = (android.widget.LinearLayout) bindings[12];
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvBody = (android.widget.TextView) bindings[5];
        this.tvBody.setTag(null);
        this.tvFavoriteCount = (android.widget.TextView) bindings[10];
        this.tvFavoriteCount.setTag(null);
        this.tvMoreDetail = (android.widget.TextView) bindings[11];
        this.tvMoreDetail.setTag(null);
        this.tvRetweetCount = (android.widget.TextView) bindings[8];
        this.tvRetweetCount.setTag(null);
        this.tvScreenName = (android.widget.TextView) bindings[3];
        this.tvScreenName.setTag(null);
        this.tvTimeAgo = (android.widget.TextView) bindings[4];
        this.tvTimeAgo.setTag(null);
        this.tvUserName = (android.widget.TextView) bindings[2];
        this.tvUserName.setTag(null);
        setRootTag(root);
        // listeners
        mCallback11 = new android.databinding.generated.callback.OnClickListener(this, 9);
        mCallback10 = new android.databinding.generated.callback.OnClickListener(this, 8);
        mCallback4 = new android.databinding.generated.callback.OnClickListener(this, 2);
        mCallback3 = new android.databinding.generated.callback.OnClickListener(this, 1);
        mCallback9 = new android.databinding.generated.callback.OnClickListener(this, 7);
        mCallback8 = new android.databinding.generated.callback.OnClickListener(this, 6);
        mCallback7 = new android.databinding.generated.callback.OnClickListener(this, 5);
        mCallback6 = new android.databinding.generated.callback.OnClickListener(this, 4);
        mCallback5 = new android.databinding.generated.callback.OnClickListener(this, 3);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean setVariable(int variableId, Object variable) {
        switch(variableId) {
            case BR.handler :
                setHandler((com.purpleblue.apps.twitterclient.handlers.TweetHandler) variable);
                return true;
            case BR.tweet :
                setTweet((com.purpleblue.apps.twitterclient.models.Tweet) variable);
                return true;
        }
        return false;
    }

    public void setHandler(com.purpleblue.apps.twitterclient.handlers.TweetHandler handler) {
        this.mHandler = handler;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }
    public com.purpleblue.apps.twitterclient.handlers.TweetHandler getHandler() {
        return mHandler;
    }
    public void setTweet(com.purpleblue.apps.twitterclient.models.Tweet tweet) {
        this.mTweet = tweet;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.tweet);
        super.requestRebind();
    }
    public com.purpleblue.apps.twitterclient.models.Tweet getTweet() {
        return mTweet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String bodyTweet = null;
        java.lang.String screenNameUserTweet = null;
        java.lang.String createdAtTweet = null;
        java.lang.String profileImageUrlUserT = null;
        com.purpleblue.apps.twitterclient.handlers.TweetHandler handler = mHandler;
        com.purpleblue.apps.twitterclient.models.Tweet tweet = mTweet;
        com.purpleblue.apps.twitterclient.models.User userTweet = null;
        java.lang.String charScreenNameUserTw = null;
        java.lang.String nameUserTweet = null;
        java.lang.String favoriteCountTweet = null;
        java.lang.String retweetCountTweet = null;

        if ((dirtyFlags & 0x6L) != 0) {



                if (tweet != null) {
                    // read tweet.body
                    bodyTweet = tweet.getBody();
                    // read tweet.createdAt
                    createdAtTweet = tweet.getCreatedAt();
                    // read tweet.user
                    userTweet = tweet.getUser();
                    // read tweet.favoriteCount
                    favoriteCountTweet = tweet.getFavoriteCount();
                    // read tweet.retweetCount
                    retweetCountTweet = tweet.getRetweetCount();
                }


                if (userTweet != null) {
                    // read tweet.user.screenName
                    screenNameUserTweet = userTweet.getScreenName();
                    // read tweet.user.profileImageUrl
                    profileImageUrlUserT = userTweet.getProfileImageUrl();
                    // read tweet.user.name
                    nameUserTweet = userTweet.getName();
                }


                // read ('@') + (tweet.user.screenName)
                charScreenNameUserTw = ('@') + (screenNameUserTweet);
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.ivFavoriteCount.setOnClickListener(mCallback9);
            this.ivProfileImage.setOnClickListener(mCallback3);
            this.ivReply.setOnClickListener(mCallback6);
            this.ivRetweetCount.setOnClickListener(mCallback7);
            this.tvFavoriteCount.setOnClickListener(mCallback10);
            this.tvMoreDetail.setOnClickListener(mCallback11);
            this.tvRetweetCount.setOnClickListener(mCallback8);
            this.tvScreenName.setOnClickListener(mCallback5);
            this.tvUserName.setOnClickListener(mCallback4);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            com.purpleblue.apps.twitterclient.adapters.UsersAdapter.loadProfileImage(this.ivProfileImage, profileImageUrlUserT);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvBody, bodyTweet);
            com.purpleblue.apps.twitterclient.adapters.TweetsAdapter.clickableStyledSpans(this.tvBody, bodyTweet);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvFavoriteCount, favoriteCountTweet);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvRetweetCount, retweetCountTweet);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvScreenName, charScreenNameUserTw);
            com.purpleblue.apps.twitterclient.adapters.TweetsAdapter.loadTimeAgo(this.tvTimeAgo, createdAtTweet);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvUserName, nameUserTweet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 9: {
                // localize variables for thread safety
                // tweet
                com.purpleblue.apps.twitterclient.models.Tweet tweet = mTweet;
                // handler != null
                boolean handlerObjectnull = false;
                // handler
                com.purpleblue.apps.twitterclient.handlers.TweetHandler handler = mHandler;



                handlerObjectnull = (handler) != (null);
                if (handlerObjectnull) {




                    handler.onClickTweetShowDetail(callbackArg_0, tweet);
                }
                break;
            }
            case 8: {
                // localize variables for thread safety
                // tweet
                com.purpleblue.apps.twitterclient.models.Tweet tweet = mTweet;
                // handler != null
                boolean handlerObjectnull = false;
                // handler
                com.purpleblue.apps.twitterclient.handlers.TweetHandler handler = mHandler;



                handlerObjectnull = (handler) != (null);
                if (handlerObjectnull) {




                    handler.onClickTweetFavorite(callbackArg_0, tweet);
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // tweet.user
                com.purpleblue.apps.twitterclient.models.User userTweet = null;
                // tweet
                com.purpleblue.apps.twitterclient.models.Tweet tweet = mTweet;
                // handler != null
                boolean handlerObjectnull = false;
                // tweet.user.screenName
                java.lang.String screenNameUserTweet = null;
                // handler
                com.purpleblue.apps.twitterclient.handlers.TweetHandler handler = mHandler;
                // tweet != null
                boolean tweetObjectnull = false;
                // tweet.user != null
                boolean userTweetObjectnull = false;



                handlerObjectnull = (handler) != (null);
                if (handlerObjectnull) {




                    tweetObjectnull = (tweet) != (null);
                    if (tweetObjectnull) {


                        userTweet = tweet.getUser();

                        userTweetObjectnull = (userTweet) != (null);
                        if (userTweetObjectnull) {


                            screenNameUserTweet = userTweet.getScreenName();

                            handler.onClickTweetShowProfile(callbackArg_0, screenNameUserTweet);
                        }
                    }
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // tweet.user
                com.purpleblue.apps.twitterclient.models.User userTweet = null;
                // tweet
                com.purpleblue.apps.twitterclient.models.Tweet tweet = mTweet;
                // handler != null
                boolean handlerObjectnull = false;
                // tweet.user.screenName
                java.lang.String screenNameUserTweet = null;
                // handler
                com.purpleblue.apps.twitterclient.handlers.TweetHandler handler = mHandler;
                // tweet != null
                boolean tweetObjectnull = false;
                // tweet.user != null
                boolean userTweetObjectnull = false;



                handlerObjectnull = (handler) != (null);
                if (handlerObjectnull) {




                    tweetObjectnull = (tweet) != (null);
                    if (tweetObjectnull) {


                        userTweet = tweet.getUser();

                        userTweetObjectnull = (userTweet) != (null);
                        if (userTweetObjectnull) {


                            screenNameUserTweet = userTweet.getScreenName();

                            handler.onClickTweetShowProfile(callbackArg_0, screenNameUserTweet);
                        }
                    }
                }
                break;
            }
            case 7: {
                // localize variables for thread safety
                // tweet
                com.purpleblue.apps.twitterclient.models.Tweet tweet = mTweet;
                // handler != null
                boolean handlerObjectnull = false;
                // handler
                com.purpleblue.apps.twitterclient.handlers.TweetHandler handler = mHandler;



                handlerObjectnull = (handler) != (null);
                if (handlerObjectnull) {




                    handler.onClickTweetFavorite(callbackArg_0, tweet);
                }
                break;
            }
            case 6: {
                // localize variables for thread safety
                // tweet
                com.purpleblue.apps.twitterclient.models.Tweet tweet = mTweet;
                // handler != null
                boolean handlerObjectnull = false;
                // handler
                com.purpleblue.apps.twitterclient.handlers.TweetHandler handler = mHandler;



                handlerObjectnull = (handler) != (null);
                if (handlerObjectnull) {




                    handler.onClickTweetRetweet(callbackArg_0, tweet);
                }
                break;
            }
            case 5: {
                // localize variables for thread safety
                // tweet
                com.purpleblue.apps.twitterclient.models.Tweet tweet = mTweet;
                // handler != null
                boolean handlerObjectnull = false;
                // handler
                com.purpleblue.apps.twitterclient.handlers.TweetHandler handler = mHandler;



                handlerObjectnull = (handler) != (null);
                if (handlerObjectnull) {




                    handler.onClickTweetRetweet(callbackArg_0, tweet);
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // tweet
                com.purpleblue.apps.twitterclient.models.Tweet tweet = mTweet;
                // handler != null
                boolean handlerObjectnull = false;
                // handler
                com.purpleblue.apps.twitterclient.handlers.TweetHandler handler = mHandler;



                handlerObjectnull = (handler) != (null);
                if (handlerObjectnull) {




                    handler.onClickTweetReply(callbackArg_0, tweet);
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // tweet.user
                com.purpleblue.apps.twitterclient.models.User userTweet = null;
                // tweet
                com.purpleblue.apps.twitterclient.models.Tweet tweet = mTweet;
                // handler != null
                boolean handlerObjectnull = false;
                // tweet.user.screenName
                java.lang.String screenNameUserTweet = null;
                // handler
                com.purpleblue.apps.twitterclient.handlers.TweetHandler handler = mHandler;
                // tweet != null
                boolean tweetObjectnull = false;
                // tweet.user != null
                boolean userTweetObjectnull = false;



                handlerObjectnull = (handler) != (null);
                if (handlerObjectnull) {




                    tweetObjectnull = (tweet) != (null);
                    if (tweetObjectnull) {


                        userTweet = tweet.getUser();

                        userTweetObjectnull = (userTweet) != (null);
                        if (userTweetObjectnull) {


                            screenNameUserTweet = userTweet.getScreenName();

                            handler.onClickTweetShowProfile(callbackArg_0, screenNameUserTweet);
                        }
                    }
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ItemTweetBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ItemTweetBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ItemTweetBinding>inflate(inflater, com.purpleblue.apps.twitterclient.R.layout.item_tweet, root, attachToRoot, bindingComponent);
    }
    public static ItemTweetBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ItemTweetBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.purpleblue.apps.twitterclient.R.layout.item_tweet, null, false), bindingComponent);
    }
    public static ItemTweetBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ItemTweetBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/item_tweet_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ItemTweetBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): handler
        flag 1 (0x2L): tweet
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}
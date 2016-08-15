package com.purpleblue.apps.twitterclient.databinding;
import com.purpleblue.apps.twitterclient.R;
import com.purpleblue.apps.twitterclient.BR;
import android.view.View;
public class ItemTweetWithPhotoBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnClickListener.Listener {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(10);
        sIncludes.setIncludes(0, 
            new String[] {"tweet_actions"},
            new int[] {6},
            new int[] {R.layout.tweet_actions});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.llBodyContainer, 7);
        sViewsWithIds.put(R.id.llBodyHead, 8);
        sViewsWithIds.put(R.id.ivMediaImage, 9);
    }
    // views
    public final android.widget.ImageView ivDivider;
    public final android.widget.ImageView ivMediaImage;
    public final android.widget.ImageView ivProfileImage;
    public final android.widget.LinearLayout llBodyContainer;
    public final android.widget.LinearLayout llBodyHead;
    public final android.widget.LinearLayout llTweetContainer;
    private final com.purpleblue.apps.twitterclient.databinding.TweetActionsBinding mboundView0;
    public final android.widget.TextView tvBody;
    public final android.widget.TextView tvScreenName;
    public final android.widget.TextView tvTimeAgo;
    // variables
    private com.purpleblue.apps.twitterclient.handlers.TweetHandler mHandler;
    private com.purpleblue.apps.twitterclient.models.Tweet mTweet;
    private final android.view.View.OnClickListener mCallback19;
    private final android.view.View.OnClickListener mCallback18;
    private final android.view.View.OnClickListener mCallback20;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemTweetWithPhotoBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds);
        this.ivDivider = (android.widget.ImageView) bindings[5];
        this.ivDivider.setTag(null);
        this.ivMediaImage = (android.widget.ImageView) bindings[9];
        this.ivProfileImage = (android.widget.ImageView) bindings[1];
        this.ivProfileImage.setTag(null);
        this.llBodyContainer = (android.widget.LinearLayout) bindings[7];
        this.llBodyHead = (android.widget.LinearLayout) bindings[8];
        this.llTweetContainer = (android.widget.LinearLayout) bindings[0];
        this.llTweetContainer.setTag(null);
        this.mboundView0 = (com.purpleblue.apps.twitterclient.databinding.TweetActionsBinding) bindings[6];
        this.tvBody = (android.widget.TextView) bindings[4];
        this.tvBody.setTag(null);
        this.tvScreenName = (android.widget.TextView) bindings[2];
        this.tvScreenName.setTag(null);
        this.tvTimeAgo = (android.widget.TextView) bindings[3];
        this.tvTimeAgo.setTag(null);
        setRootTag(root);
        // listeners
        mCallback19 = new android.databinding.generated.callback.OnClickListener(this, 2);
        mCallback18 = new android.databinding.generated.callback.OnClickListener(this, 1);
        mCallback20 = new android.databinding.generated.callback.OnClickListener(this, 3);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        mboundView0.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (mboundView0.hasPendingBindings()) {
            return true;
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

        if ((dirtyFlags & 0x6L) != 0) {



                if (tweet != null) {
                    // read tweet.body
                    bodyTweet = tweet.getBody();
                    // read tweet.createdAt
                    createdAtTweet = tweet.getCreatedAt();
                    // read tweet.user
                    userTweet = tweet.getUser();
                }


                if (userTweet != null) {
                    // read tweet.user.screenName
                    screenNameUserTweet = userTweet.getScreenName();
                    // read tweet.user.profileImageUrl
                    profileImageUrlUserT = userTweet.getProfileImageUrl();
                }


                // read ('@') + (tweet.user.screenName)
                charScreenNameUserTw = ('@') + (screenNameUserTweet);
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.ivDivider.setOnClickListener(mCallback20);
            this.ivProfileImage.setOnClickListener(mCallback18);
            this.tvScreenName.setOnClickListener(mCallback19);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            com.purpleblue.apps.twitterclient.adapters.UsersAdapter.loadProfileImage(this.ivProfileImage, profileImageUrlUserT);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvBody, bodyTweet);
            com.purpleblue.apps.twitterclient.adapters.TweetsAdapter.clickableStyledSpans(this.tvBody, bodyTweet);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvScreenName, charScreenNameUserTw);
            com.purpleblue.apps.twitterclient.adapters.TweetsAdapter.loadTimeAgo(this.tvTimeAgo, createdAtTweet);
        }
        mboundView0.executePendingBindings();
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
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

    public static ItemTweetWithPhotoBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ItemTweetWithPhotoBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ItemTweetWithPhotoBinding>inflate(inflater, com.purpleblue.apps.twitterclient.R.layout.item_tweet_with_photo, root, attachToRoot, bindingComponent);
    }
    public static ItemTweetWithPhotoBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ItemTweetWithPhotoBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.purpleblue.apps.twitterclient.R.layout.item_tweet_with_photo, null, false), bindingComponent);
    }
    public static ItemTweetWithPhotoBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ItemTweetWithPhotoBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/item_tweet_with_photo_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ItemTweetWithPhotoBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): handler
        flag 1 (0x2L): tweet
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}
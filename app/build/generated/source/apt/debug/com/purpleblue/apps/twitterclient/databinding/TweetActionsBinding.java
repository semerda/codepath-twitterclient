package com.purpleblue.apps.twitterclient.databinding;
import com.purpleblue.apps.twitterclient.R;
import com.purpleblue.apps.twitterclient.BR;
import android.view.View;
public class TweetActionsBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnClickListener.Listener {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    public final android.widget.ImageView ivFavoriteCount;
    public final android.widget.ImageView ivReply;
    public final android.widget.ImageView ivRetweetCount;
    private final android.widget.LinearLayout mboundView0;
    public final android.widget.TextView tvFavoriteCount;
    public final android.widget.TextView tvMoreDetail;
    public final android.widget.TextView tvRetweetCount;
    // variables
    private com.purpleblue.apps.twitterclient.handlers.TweetHandler mHandler;
    private com.purpleblue.apps.twitterclient.models.Tweet mTweet;
    private final android.view.View.OnClickListener mCallback13;
    private final android.view.View.OnClickListener mCallback12;
    private final android.view.View.OnClickListener mCallback15;
    private final android.view.View.OnClickListener mCallback14;
    private final android.view.View.OnClickListener mCallback17;
    private final android.view.View.OnClickListener mCallback16;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public TweetActionsBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds);
        this.ivFavoriteCount = (android.widget.ImageView) bindings[4];
        this.ivFavoriteCount.setTag(null);
        this.ivReply = (android.widget.ImageView) bindings[1];
        this.ivReply.setTag(null);
        this.ivRetweetCount = (android.widget.ImageView) bindings[2];
        this.ivRetweetCount.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvFavoriteCount = (android.widget.TextView) bindings[5];
        this.tvFavoriteCount.setTag(null);
        this.tvMoreDetail = (android.widget.TextView) bindings[6];
        this.tvMoreDetail.setTag(null);
        this.tvRetweetCount = (android.widget.TextView) bindings[3];
        this.tvRetweetCount.setTag(null);
        setRootTag(root);
        // listeners
        mCallback13 = new android.databinding.generated.callback.OnClickListener(this, 2);
        mCallback12 = new android.databinding.generated.callback.OnClickListener(this, 1);
        mCallback15 = new android.databinding.generated.callback.OnClickListener(this, 4);
        mCallback14 = new android.databinding.generated.callback.OnClickListener(this, 3);
        mCallback17 = new android.databinding.generated.callback.OnClickListener(this, 6);
        mCallback16 = new android.databinding.generated.callback.OnClickListener(this, 5);
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
        com.purpleblue.apps.twitterclient.handlers.TweetHandler handler = mHandler;
        com.purpleblue.apps.twitterclient.models.Tweet tweet = mTweet;
        java.lang.String favoriteCountTweet = null;
        java.lang.String retweetCountTweet = null;

        if ((dirtyFlags & 0x6L) != 0) {



                if (tweet != null) {
                    // read tweet.favoriteCount
                    favoriteCountTweet = tweet.getFavoriteCount();
                    // read tweet.retweetCount
                    retweetCountTweet = tweet.getRetweetCount();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.ivFavoriteCount.setOnClickListener(mCallback15);
            this.ivReply.setOnClickListener(mCallback12);
            this.ivRetweetCount.setOnClickListener(mCallback13);
            this.tvFavoriteCount.setOnClickListener(mCallback16);
            this.tvMoreDetail.setOnClickListener(mCallback17);
            this.tvRetweetCount.setOnClickListener(mCallback14);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvFavoriteCount, favoriteCountTweet);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvRetweetCount, retweetCountTweet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
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
            case 1: {
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




                    handler.onClickTweetFavorite(callbackArg_0, tweet);
                }
                break;
            }
            case 3: {
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




                    handler.onClickTweetShowDetail(callbackArg_0, tweet);
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




                    handler.onClickTweetFavorite(callbackArg_0, tweet);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static TweetActionsBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static TweetActionsBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<TweetActionsBinding>inflate(inflater, com.purpleblue.apps.twitterclient.R.layout.tweet_actions, root, attachToRoot, bindingComponent);
    }
    public static TweetActionsBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static TweetActionsBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.purpleblue.apps.twitterclient.R.layout.tweet_actions, null, false), bindingComponent);
    }
    public static TweetActionsBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static TweetActionsBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/tweet_actions_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new TweetActionsBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): handler
        flag 1 (0x2L): tweet
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}
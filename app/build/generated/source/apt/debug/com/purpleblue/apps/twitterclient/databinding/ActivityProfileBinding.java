package com.purpleblue.apps.twitterclient.databinding;
import com.purpleblue.apps.twitterclient.R;
import com.purpleblue.apps.twitterclient.BR;
import android.view.View;
public class ActivityProfileBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnClickListener.Listener {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.ivProfileBannerImage, 3);
        sViewsWithIds.put(R.id.toolbar, 4);
        sViewsWithIds.put(R.id.toolbar_title, 5);
        sViewsWithIds.put(R.id.rlUserHeader, 6);
        sViewsWithIds.put(R.id.ivProfileImage, 7);
        sViewsWithIds.put(R.id.tvFullName, 8);
        sViewsWithIds.put(R.id.tvTagline, 9);
        sViewsWithIds.put(R.id.llCounts, 10);
        sViewsWithIds.put(R.id.tabs, 11);
        sViewsWithIds.put(R.id.viewpager, 12);
        sViewsWithIds.put(R.id.google_progress, 13);
    }
    // views
    public final android.widget.ProgressBar googleProgress;
    public final android.widget.ImageView ivProfileBannerImage;
    public final android.widget.ImageView ivProfileImage;
    public final android.widget.LinearLayout llCounts;
    private final android.widget.RelativeLayout mboundView0;
    public final android.widget.RelativeLayout rlUserHeader;
    public final com.astuetz.PagerSlidingTabStrip tabs;
    public final android.support.v7.widget.Toolbar toolbar;
    public final android.widget.TextView toolbarTitle;
    public final android.widget.TextView tvFollowers;
    public final android.widget.TextView tvFollowing;
    public final android.widget.TextView tvFullName;
    public final android.widget.TextView tvTagline;
    public final android.support.v4.view.ViewPager viewpager;
    // variables
    private com.purpleblue.apps.twitterclient.handlers.TweetHandler mHandler;
    private com.purpleblue.apps.twitterclient.models.User mUser;
    private final android.view.View.OnClickListener mCallback2;
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityProfileBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds);
        this.googleProgress = (android.widget.ProgressBar) bindings[13];
        this.ivProfileBannerImage = (android.widget.ImageView) bindings[3];
        this.ivProfileImage = (android.widget.ImageView) bindings[7];
        this.llCounts = (android.widget.LinearLayout) bindings[10];
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.rlUserHeader = (android.widget.RelativeLayout) bindings[6];
        this.tabs = (com.astuetz.PagerSlidingTabStrip) bindings[11];
        this.toolbar = (android.support.v7.widget.Toolbar) bindings[4];
        this.toolbarTitle = (android.widget.TextView) bindings[5];
        this.tvFollowers = (android.widget.TextView) bindings[1];
        this.tvFollowers.setTag(null);
        this.tvFollowing = (android.widget.TextView) bindings[2];
        this.tvFollowing.setTag(null);
        this.tvFullName = (android.widget.TextView) bindings[8];
        this.tvTagline = (android.widget.TextView) bindings[9];
        this.viewpager = (android.support.v4.view.ViewPager) bindings[12];
        setRootTag(root);
        // listeners
        mCallback2 = new android.databinding.generated.callback.OnClickListener(this, 2);
        mCallback1 = new android.databinding.generated.callback.OnClickListener(this, 1);
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
            case BR.user :
                setUser((com.purpleblue.apps.twitterclient.models.User) variable);
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
    public void setUser(com.purpleblue.apps.twitterclient.models.User user) {
        this.mUser = user;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.user);
        super.requestRebind();
    }
    public com.purpleblue.apps.twitterclient.models.User getUser() {
        return mUser;
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
        com.purpleblue.apps.twitterclient.models.User user = mUser;
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.tvFollowers.setOnClickListener(mCallback1);
            this.tvFollowing.setOnClickListener(mCallback2);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // user
                com.purpleblue.apps.twitterclient.models.User user = mUser;
                // handler != null
                boolean handlerObjectnull = false;
                // handler
                com.purpleblue.apps.twitterclient.handlers.TweetHandler handler = mHandler;



                handlerObjectnull = (handler) != (null);
                if (handlerObjectnull) {




                    handler.onClickShowFollowing(callbackArg_0, user);
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // user
                com.purpleblue.apps.twitterclient.models.User user = mUser;
                // handler != null
                boolean handlerObjectnull = false;
                // handler
                com.purpleblue.apps.twitterclient.handlers.TweetHandler handler = mHandler;



                handlerObjectnull = (handler) != (null);
                if (handlerObjectnull) {




                    handler.onClickShowFollowers(callbackArg_0, user);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ActivityProfileBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityProfileBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityProfileBinding>inflate(inflater, com.purpleblue.apps.twitterclient.R.layout.activity_profile, root, attachToRoot, bindingComponent);
    }
    public static ActivityProfileBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityProfileBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.purpleblue.apps.twitterclient.R.layout.activity_profile, null, false), bindingComponent);
    }
    public static ActivityProfileBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityProfileBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_profile_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityProfileBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): handler
        flag 1 (0x2L): user
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}
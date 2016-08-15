package com.purpleblue.apps.twitterclient.databinding;
import com.purpleblue.apps.twitterclient.R;
import com.purpleblue.apps.twitterclient.BR;
import android.view.View;
public class ItemUserBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.ivDivider, 6);
    }
    // views
    public final android.widget.ImageView ivDivider;
    public final android.widget.ImageView ivProfileImage;
    private final android.widget.RelativeLayout mboundView0;
    public final android.widget.TextView tvBody;
    public final android.widget.TextView tvScreenName;
    public final android.widget.TextView tvTimeAgo;
    public final android.widget.TextView tvUserName;
    // variables
    private com.purpleblue.apps.twitterclient.models.User mUser;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemUserBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds);
        this.ivDivider = (android.widget.ImageView) bindings[6];
        this.ivProfileImage = (android.widget.ImageView) bindings[1];
        this.ivProfileImage.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvBody = (android.widget.TextView) bindings[5];
        this.tvBody.setTag(null);
        this.tvScreenName = (android.widget.TextView) bindings[3];
        this.tvScreenName.setTag(null);
        this.tvTimeAgo = (android.widget.TextView) bindings[4];
        this.tvTimeAgo.setTag(null);
        this.tvUserName = (android.widget.TextView) bindings[2];
        this.tvUserName.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
            case BR.user :
                setUser((com.purpleblue.apps.twitterclient.models.User) variable);
                return true;
        }
        return false;
    }

    public void setUser(com.purpleblue.apps.twitterclient.models.User user) {
        this.mUser = user;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
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
        java.lang.String profileImageUrlUser = null;
        java.lang.String nameUser = null;
        java.lang.String tagLineUser = null;
        java.lang.String charScreenNameUser = null;
        java.lang.String createdAtUser = null;
        java.lang.String screenNameUser = null;
        com.purpleblue.apps.twitterclient.models.User user = mUser;

        if ((dirtyFlags & 0x3L) != 0) {



                if (user != null) {
                    // read user.profileImageUrl
                    profileImageUrlUser = user.getProfileImageUrl();
                    // read user.name
                    nameUser = user.getName();
                    // read user.tagLine
                    tagLineUser = user.getTagLine();
                    // read user.createdAt
                    createdAtUser = user.getCreatedAt();
                    // read user.screenName
                    screenNameUser = user.getScreenName();
                }


                // read ('@') + (user.screenName)
                charScreenNameUser = ('@') + (screenNameUser);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.purpleblue.apps.twitterclient.adapters.UsersAdapter.loadProfileImage(this.ivProfileImage, profileImageUrlUser);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvBody, tagLineUser);
            com.purpleblue.apps.twitterclient.adapters.TweetsAdapter.clickableStyledSpans(this.tvBody, tagLineUser);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvScreenName, charScreenNameUser);
            com.purpleblue.apps.twitterclient.adapters.UsersAdapter.loadJoinedTimeAgo(this.tvTimeAgo, createdAtUser);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvUserName, nameUser);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ItemUserBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ItemUserBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ItemUserBinding>inflate(inflater, com.purpleblue.apps.twitterclient.R.layout.item_user, root, attachToRoot, bindingComponent);
    }
    public static ItemUserBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ItemUserBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.purpleblue.apps.twitterclient.R.layout.item_user, null, false), bindingComponent);
    }
    public static ItemUserBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ItemUserBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/item_user_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ItemUserBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): user
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}
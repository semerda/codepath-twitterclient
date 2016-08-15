package com.purpleblue.apps.twitterclient.databinding;
import com.purpleblue.apps.twitterclient.R;
import com.purpleblue.apps.twitterclient.BR;
import android.view.View;
public class FragmentUsersListBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.swipeRefresh, 1);
        sViewsWithIds.put(R.id.rvUsers, 2);
    }
    // views
    public final android.support.design.widget.CoordinatorLayout mainContent;
    public final android.support.v7.widget.RecyclerView rvUsers;
    public final android.support.v4.widget.SwipeRefreshLayout swipeRefresh;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentUsersListBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds);
        this.mainContent = (android.support.design.widget.CoordinatorLayout) bindings[0];
        this.mainContent.setTag(null);
        this.rvUsers = (android.support.v7.widget.RecyclerView) bindings[2];
        this.swipeRefresh = (android.support.v4.widget.SwipeRefreshLayout) bindings[1];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
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
        }
        return false;
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
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static FragmentUsersListBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static FragmentUsersListBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FragmentUsersListBinding>inflate(inflater, com.purpleblue.apps.twitterclient.R.layout.fragment_users_list, root, attachToRoot, bindingComponent);
    }
    public static FragmentUsersListBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static FragmentUsersListBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.purpleblue.apps.twitterclient.R.layout.fragment_users_list, null, false), bindingComponent);
    }
    public static FragmentUsersListBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static FragmentUsersListBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fragment_users_list_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FragmentUsersListBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}
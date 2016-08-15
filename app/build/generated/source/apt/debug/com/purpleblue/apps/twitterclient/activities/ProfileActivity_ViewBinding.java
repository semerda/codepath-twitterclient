// Generated code from Butter Knife. Do not modify!
package com.purpleblue.apps.twitterclient.activities;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.purpleblue.apps.twitterclient.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ProfileActivity_ViewBinding<T extends ProfileActivity> implements Unbinder {
  protected T target;

  public ProfileActivity_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.ivProfileBannerImage = finder.findRequiredViewAsType(source, R.id.ivProfileBannerImage, "field 'ivProfileBannerImage'", ImageView.class);
    target.toolbarTitle = finder.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    target.mProgressBar = finder.findRequiredViewAsType(source, R.id.google_progress, "field 'mProgressBar'", ProgressBar.class);
    target.tvFullName = finder.findRequiredViewAsType(source, R.id.tvFullName, "field 'tvFullName'", TextView.class);
    target.tvTagline = finder.findRequiredViewAsType(source, R.id.tvTagline, "field 'tvTagline'", TextView.class);
    target.tvFollowers = finder.findRequiredViewAsType(source, R.id.tvFollowers, "field 'tvFollowers'", TextView.class);
    target.tvFollowing = finder.findRequiredViewAsType(source, R.id.tvFollowing, "field 'tvFollowing'", TextView.class);
    target.ivProfileImage = finder.findRequiredViewAsType(source, R.id.ivProfileImage, "field 'ivProfileImage'", ImageView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.ivProfileBannerImage = null;
    target.toolbarTitle = null;
    target.mProgressBar = null;
    target.tvFullName = null;
    target.tvTagline = null;
    target.tvFollowers = null;
    target.tvFollowing = null;
    target.ivProfileImage = null;

    this.target = null;
  }
}

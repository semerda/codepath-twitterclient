// Generated code from Butter Knife. Do not modify!
package com.purpleblue.apps.twitterclient.activities;

import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.purpleblue.apps.twitterclient.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class TimelineActivity_ViewBinding<T extends TimelineActivity> implements Unbinder {
  protected T target;

  public TimelineActivity_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.mProgressBar = finder.findRequiredViewAsType(source, R.id.google_progress, "field 'mProgressBar'", ProgressBar.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mProgressBar = null;

    this.target = null;
  }
}

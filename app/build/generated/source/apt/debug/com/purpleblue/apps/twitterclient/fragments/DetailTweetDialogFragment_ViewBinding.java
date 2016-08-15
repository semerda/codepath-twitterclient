// Generated code from Butter Knife. Do not modify!
package com.purpleblue.apps.twitterclient.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import com.purpleblue.apps.twitterclient.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class DetailTweetDialogFragment_ViewBinding<T extends DetailTweetDialogFragment> implements Unbinder {
  protected T target;

  private View view2131492994;

  public DetailTweetDialogFragment_ViewBinding(final T target, final Finder finder, Object source) {
    this.target = target;

    View view;
    view = finder.findRequiredView(source, R.id.btnClose, "field 'btnClose' and method 'onClickClose'");
    target.btnClose = finder.castView(view, R.id.btnClose, "field 'btnClose'", Button.class);
    view2131492994 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickClose(finder.<Button>castParam(p0, "doClick", 0, "onClickClose", 0));
      }
    });
    target.tvTweetUserName = finder.findRequiredViewAsType(source, R.id.tvTweetUserName, "field 'tvTweetUserName'", TextView.class);
    target.tvTweetScreenName = finder.findRequiredViewAsType(source, R.id.tvTweetScreenName, "field 'tvTweetScreenName'", TextView.class);
    target.tvTweetCreatedAt = finder.findRequiredViewAsType(source, R.id.tvTweetCreatedAt, "field 'tvTweetCreatedAt'", TextView.class);
    target.ivTweetProfileImage = finder.findRequiredViewAsType(source, R.id.ivTweetProfileImage, "field 'ivTweetProfileImage'", ImageView.class);
    target.tvTweetBody = finder.findRequiredViewAsType(source, R.id.tvTweetBody, "field 'tvTweetBody'", TextView.class);
    target.ivTweetMedia = finder.findRequiredViewAsType(source, R.id.ivTweetMedia, "field 'ivTweetMedia'", ImageView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.btnClose = null;
    target.tvTweetUserName = null;
    target.tvTweetScreenName = null;
    target.tvTweetCreatedAt = null;
    target.ivTweetProfileImage = null;
    target.tvTweetBody = null;
    target.ivTweetMedia = null;

    view2131492994.setOnClickListener(null);
    view2131492994 = null;

    this.target = null;
  }
}

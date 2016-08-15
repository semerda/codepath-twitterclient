// Generated code from Butter Knife. Do not modify!
package com.purpleblue.apps.twitterclient.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import com.purpleblue.apps.twitterclient.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ComposeTweetDialogFragment_ViewBinding<T extends ComposeTweetDialogFragment> implements Unbinder {
  protected T target;

  private View view2131492994;

  private View view2131492999;

  public ComposeTweetDialogFragment_ViewBinding(final T target, final Finder finder, Object source) {
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
    target.tvAccountUserName = finder.findRequiredViewAsType(source, R.id.tvAccountUserName, "field 'tvAccountUserName'", TextView.class);
    target.tvAccountScreenName = finder.findRequiredViewAsType(source, R.id.tvAccountScreenName, "field 'tvAccountScreenName'", TextView.class);
    target.ivAccountProfileImage = finder.findRequiredViewAsType(source, R.id.ivAccountProfileImage, "field 'ivAccountProfileImage'", ImageView.class);
    target.etStatus = finder.findRequiredViewAsType(source, R.id.etStatus, "field 'etStatus'", EditText.class);
    view = finder.findRequiredView(source, R.id.btnTweet, "field 'btnTweet' and method 'onClickTweetStatus'");
    target.btnTweet = finder.castView(view, R.id.btnTweet, "field 'btnTweet'", Button.class);
    view2131492999 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickTweetStatus(finder.<Button>castParam(p0, "doClick", 0, "onClickTweetStatus", 0));
      }
    });
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.btnClose = null;
    target.tvAccountUserName = null;
    target.tvAccountScreenName = null;
    target.ivAccountProfileImage = null;
    target.etStatus = null;
    target.btnTweet = null;

    view2131492994.setOnClickListener(null);
    view2131492994 = null;
    view2131492999.setOnClickListener(null);
    view2131492999 = null;

    this.target = null;
  }
}

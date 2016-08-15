
package android.databinding;
import com.purpleblue.apps.twitterclient.BR;
class DataBinderMapper {
    final static int TARGET_MIN_SDK = 19;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.purpleblue.apps.twitterclient.R.layout.fragment_users_list:
                    return com.purpleblue.apps.twitterclient.databinding.FragmentUsersListBinding.bind(view, bindingComponent);
                case com.purpleblue.apps.twitterclient.R.layout.activity_profile:
                    return com.purpleblue.apps.twitterclient.databinding.ActivityProfileBinding.bind(view, bindingComponent);
                case com.purpleblue.apps.twitterclient.R.layout.item_tweet:
                    return com.purpleblue.apps.twitterclient.databinding.ItemTweetBinding.bind(view, bindingComponent);
                case com.purpleblue.apps.twitterclient.R.layout.tweet_actions:
                    return com.purpleblue.apps.twitterclient.databinding.TweetActionsBinding.bind(view, bindingComponent);
                case com.purpleblue.apps.twitterclient.R.layout.item_user:
                    return com.purpleblue.apps.twitterclient.databinding.ItemUserBinding.bind(view, bindingComponent);
                case com.purpleblue.apps.twitterclient.R.layout.item_tweet_with_photo:
                    return com.purpleblue.apps.twitterclient.databinding.ItemTweetWithPhotoBinding.bind(view, bindingComponent);
                case com.purpleblue.apps.twitterclient.R.layout.fragment_tweets_list:
                    return com.purpleblue.apps.twitterclient.databinding.FragmentTweetsListBinding.bind(view, bindingComponent);
        }
        return null;
    }
    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case -736620720: {
                if(tag.equals("layout/fragment_users_list_0")) {
                    return com.purpleblue.apps.twitterclient.R.layout.fragment_users_list;
                }
                break;
            }
            case 366786799: {
                if(tag.equals("layout/activity_profile_0")) {
                    return com.purpleblue.apps.twitterclient.R.layout.activity_profile;
                }
                break;
            }
            case -657259653: {
                if(tag.equals("layout/item_tweet_0")) {
                    return com.purpleblue.apps.twitterclient.R.layout.item_tweet;
                }
                break;
            }
            case -13904837: {
                if(tag.equals("layout/tweet_actions_0")) {
                    return com.purpleblue.apps.twitterclient.R.layout.tweet_actions;
                }
                break;
            }
            case -1243181053: {
                if(tag.equals("layout/item_user_0")) {
                    return com.purpleblue.apps.twitterclient.R.layout.item_user;
                }
                break;
            }
            case -959297857: {
                if(tag.equals("layout/item_tweet_with_photo_0")) {
                    return com.purpleblue.apps.twitterclient.R.layout.item_tweet_with_photo;
                }
                break;
            }
            case 2117015650: {
                if(tag.equals("layout/fragment_tweets_list_0")) {
                    return com.purpleblue.apps.twitterclient.R.layout.fragment_tweets_list;
                }
                break;
            }
        }
        return 0;
    }
    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"handler"
            ,"tweet"
            ,"user"};
    }
}
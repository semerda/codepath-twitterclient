package com.purpleblue.apps.twitterclient.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by ernest on 8/1/16.
 *
 * Source of JSON
 * https://dev.twitter.com/rest/reference/get/account/verify_credentials
 *
 * ActiveAndroid
 * http://guides.codepath.com/android/ActiveAndroid-Guide
 */

@Table(name = "Users")
public class User extends Model implements Parcelable {

    // This is a regular field
    @Column(name = "Name")
    private String name;

    @Column(name = "UId")
    private long uid;

    @Column(name = "ScreenName")
    private String screenName;

    @Column(name = "ProfileImageUrl")
    private String profileImageUrl;

    @Column(name = "TagLine")
    private String tagLine;

    @Column(name = "FollowersCount")
    private int followersCount;

    @Column(name = "FriendsCount")
    private int friendsCount;

    @Column(name = "CreatedAt")
    private String createdAt;

    // Make sure to have a default constructor for every ActiveAndroid model
    public User(){
        super();
    }

    public User(String name, long uid, String screenName, String profileImageUrl, String tagLine, int followersCount, int friendsCount, String createdAt){
        super();
        this.name = name;
        this.uid = uid;
        this.screenName = screenName;
        this.profileImageUrl = profileImageUrl;
        this.tagLine = tagLine;
        this.followersCount = followersCount;
        this.friendsCount = friendsCount;
        this.createdAt = createdAt;
    }

    // Used to return items from another table based on the foreign key
    public List<Tweet> items() {
        return getMany(Tweet.class, "User");
    }

    public String getName() {
        return name;
    } // actual user name eg. Ernest Semerda

    public long getUid() {
        return uid;
    }

    public String getScreenName() {
        return screenName;
    } // username or handle eg. ernestsemerda

    public String getPrefixedScreenName() {
        return String.format("@%s", screenName);
    } // username or handle eg. @ernestsemerda

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public String getTagLine() {
        return tagLine;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public String getFollowersCountFormatted() {
        return NumberFormat.getNumberInstance(Locale.US).format(followersCount);
    }

    public int getFriendsCount() {
        return friendsCount;
    }

    public String getFriendsCountFormatted() {
        return NumberFormat.getNumberInstance(Locale.US).format(friendsCount);
    }

    public String getCreatedAt() {
        return createdAt;
    }

    // deserialize the user object => User
    public static User fromJSON(JSONObject json) {
        User user = new User();
        // Extract and fill the values
        try {
            user.name = json.getString("name");
            user.uid = json.getLong("id");
            user.screenName = json.getString("screen_name");
            // Note: using bigger version of profile images - clearer
            // Ref: https://dev.twitter.com/overview/general/user-profile-images-and-banners
            user.profileImageUrl = json.getString("profile_image_url_https").replace("_normal", "_bigger");

            user.tagLine = json.getString("description");
            user.followersCount = json.getInt("followers_count");
            user.friendsCount = json.getInt("friends_count");

            user.createdAt = json.getString("created_at");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Return a user
        return user;
    }

    // Tweet.fromJSONArray([ { ... }, { ... } ] => List<Tweet>
    public static ArrayList<User> fromJSONArray(JSONArray jsonArray) {
        ArrayList<User> users = new ArrayList<>();

        // Iterate the json array and create tweets
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject userJson = jsonArray.getJSONObject(i);
                User user = User.fromJSON(userJson);
                if (user != null) {
                    users.add(user);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                continue; // even if 1 tweet fails continue to process the other tweets
            }
        }

        // Return the finished list
        return users;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeLong(this.uid);
        dest.writeString(this.screenName);
        dest.writeString(this.profileImageUrl);
        dest.writeString(this.tagLine);
        dest.writeInt(this.followersCount);
        dest.writeInt(this.friendsCount);
        dest.writeString(this.createdAt);
    }

    protected User(Parcel in) {
        this.name = in.readString();
        this.uid = in.readLong();
        this.screenName = in.readString();
        this.profileImageUrl = in.readString();
        this.tagLine = in.readString();
        this.followersCount = in.readInt();
        this.friendsCount = in.readInt();
        this.createdAt = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}

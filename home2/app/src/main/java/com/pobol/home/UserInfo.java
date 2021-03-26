package com.pobol.home;

import android.util.Log;

public class UserInfo {
    private static final String TAG="myTag";
    public String userName;
    public String userEmail;
    public String password;
    public String confirmedPassword;

    public void getAll(){
        Log.d(TAG, "user="+userName+", userEmail="+userEmail+" ,password="+password+" , confirmed password="+confirmedPassword);
    }
}

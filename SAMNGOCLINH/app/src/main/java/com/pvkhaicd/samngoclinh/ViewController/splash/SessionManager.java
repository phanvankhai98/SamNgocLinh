package com.pvkhaicd.samngoclinh.ViewController.splash;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashMap;

public class SessionManager {
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor mEditor;
    Context mContext;
    public static final String PREF_NAME = "USER_DETAIL";
    private static final String IS_LOGIN = "IS LOGIN";
    public static final String KEY_PHONE_NUMBER = "PHONE NUMBER";
    public static final String KEY_NAME = "NAME";

    public SessionManager(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        mContext = context;
    }

    public void createLoginSession(String phone,String name){
        mEditor.putBoolean(IS_LOGIN,true);
        mEditor.putString(KEY_NAME,name);
        mEditor.putString(KEY_PHONE_NUMBER,phone);
        mEditor.commit();
    }

    public HashMap<String,String> getUserDetail(){
        HashMap<String,String> userDetail = new HashMap<String,String>();
        userDetail.put(KEY_NAME,mSharedPreferences.getString(KEY_NAME,null));
        userDetail.put(KEY_PHONE_NUMBER,mSharedPreferences.getString(KEY_PHONE_NUMBER,null));
        return userDetail;
    }

    public void logoutUser(){
        mEditor.clear();
        mEditor.commit();
        Intent intent = new Intent(mContext,LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }
    public boolean isLogin(){
       return mSharedPreferences.getBoolean(IS_LOGIN,false);
    }
}

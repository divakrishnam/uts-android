package com.example.a_uts_kadek_1174006;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context mContext;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "prefname";
    private static final String USER_NAME = "username";
    private static final String EMAIL = "email";
    private static final String PASS = "pass";
    private static final String CPASS = "cpass";

    public SharedPref(Context context){
        this.mContext = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setUser(String username, String password, String email, String cpassword){
        editor.putString(USER_NAME, username);
        editor.putString(EMAIL, email);
        editor.putString(PASS, password);
        editor.putString(CPASS, cpassword);
        editor.commit();
    }

    public String getUserName(){
        return pref.getString(USER_NAME, null);
    }

    public String getPass(){
        return pref.getString(PASS, null);
    }

    public String getEmail(){
        return pref.getString(EMAIL, null);
    }

    public String getCPass(){
        return pref.getString(CPASS, null);
    }

    public boolean isLogin(){
        if (pref.getString(USER_NAME, null) != null)
            return true;
        return false;
    }

    public void logout(){
        editor.clear();
        editor.commit();
    }
}

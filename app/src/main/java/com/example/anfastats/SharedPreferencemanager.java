package com.example.anfastats;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.anfastats.ModelData.User;


public class SharedPreferencemanager {

    private static  final String Shared_Pref_Name = "new_shared_pref";

    private static com.example.anfastats.SharedPreferencemanager mInstance;
    private static Context mcontext;

    private SharedPreferencemanager(Context mcontext){
        this.mcontext = mcontext;
    }

    public static synchronized com.example.anfastats.SharedPreferencemanager getmInstance(Context mcontext){

        if(mInstance == null){
            mInstance = new com.example.anfastats.SharedPreferencemanager(mcontext);

        }
        return mInstance;
    }

    public void saveUser(User user){

        SharedPreferences sharedPreferences = mcontext.getSharedPreferences(Shared_Pref_Name,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("name",user.getName());
        editor.putInt("id",user.getUserid());
        editor.apply();


    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mcontext.getSharedPreferences(Shared_Pref_Name, Context.MODE_PRIVATE);
        return sharedPreferences.getInt("id", -1)!= -1;
    }

    public User getUser(){
        SharedPreferences sharedPreferences = mcontext.getSharedPreferences(Shared_Pref_Name,Context.MODE_PRIVATE);
        return new User(

                sharedPreferences.getString("contact",null),
                sharedPreferences.getString("password",null),
                sharedPreferences.getInt("id",-1),
                sharedPreferences.getString("name",null),
                sharedPreferences.getInt("error",-1)


                );

    }

    public void clear(){
        SharedPreferences sharedPreferences = mcontext.getSharedPreferences(Shared_Pref_Name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

    }



}

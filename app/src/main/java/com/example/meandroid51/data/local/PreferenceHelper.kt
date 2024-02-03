package com.example.meandroid51.data.local

import android.content.Context

class PreferenceHelper (context : Context){
    private val preferenceHelper = context.getSharedPreferences("nyPref",Context.MODE_PRIVATE)

    var username: String?
        get() = preferenceHelper.getString(USER_NAME_KEY, "")
        set(value){
            preferenceHelper.edit().putString(USER_NAME_KEY,value).apply()
        }
    var age: String?
        get() = preferenceHelper.getString(AGE_KEY,"")
        set(value){
            preferenceHelper.edit().putString(AGE_KEY,value).apply()
        }
    var email: String?
        get() = preferenceHelper.getString(EMAIL_KEY,"")
        set(value){
            preferenceHelper.edit().putString(EMAIL_KEY , value).apply()
        }
    var password: String?
        get() = preferenceHelper.getString(PASSWORD_KEY, "")
        set(value){
            preferenceHelper.edit().putString(PASSWORD_KEY ,value).apply()
        }


    companion object{
        private const val USER_NAME_KEY = "username"
        private const val AGE_KEY = "age"
        private const val EMAIL_KEY = "email"
        private const val PASSWORD_KEY = "password"
    }

}
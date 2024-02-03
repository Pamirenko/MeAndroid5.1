package com.example.meandroid51.ui.fragments.edit

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.UserInfo

class EditFragmentViewModel : ViewModel(){
    private lateinit var sharedPreferences: SharedPreferences

    private val _userInfoLiveData = MutableLiveData<UserInfo>()
    val userInfoLiveData : LiveData<UserInfo> = _userInfoLiveData

    fun initialize(context: Context){
        sharedPreferences = context.getSharedPreferences("username",Context.MODE_PRIVATE)
    }
    fun LoadUserInfo(){
        val username = sharedPreferences.getString("username","")?:""
        val age = sharedPreferences.getInt("age",0)
        val email = sharedPreferences.getString("email","")?:""
        val password = sharedPreferences.getString("password","")?:""

        val userInfo = com.example.meandroid51.data.model.UserInfo(username, age, email, password)
        _userInfoLiveData.value = userInfo
    }
    fun siveChanges(username: String, age : Int, email: String, password: String){
        sharedPreferences.edit().apply{
            putString("username", username)
            putInt("age", age)
            putString("email", email)
            putString("password", password)
            apply()
        }
    }


}
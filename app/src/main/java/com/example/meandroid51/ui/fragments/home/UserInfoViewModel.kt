package com.example.meandroid51.ui.fragments.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.meandroid51.data.model.UserInfo

class UserInfoViewModel : ViewModel() {
    private val _userInfoLiveData = MutableLiveData<UserInfo>()
    val userInfoLiveData : LiveData<UserInfo> = _userInfoLiveData

    fun LoadUserInfo(context: Context){
        val sharedPreferences =
            context.getSharedPreferences("user_info",Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("username" , "")?: ""
        val age =  sharedPreferences.getInt("age", 0)
        val email = sharedPreferences.getString("password","")?: ""
        val password = sharedPreferences.getString("password","")?: ""

        val userInfo = UserInfo(username , age , email, password)
        _userInfoLiveData.value = userInfo
    }
}
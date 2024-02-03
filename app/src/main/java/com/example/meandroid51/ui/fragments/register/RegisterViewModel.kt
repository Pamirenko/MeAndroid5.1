package com.example.meandroid51.ui.fragments.register

import android.content.Context
import android.content.SharedPreferences
import android.provider.Settings.Global.putInt
import android.provider.Settings.Global.putString
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {
    private lateinit var sharedPreferences: SharedPreferences

    fun initiaLize(context: Context) {
        sharedPreferences = context.getSharedPreferences("user_info", Context.MODE_PRIVATE)
    }


    fun registerUser(username: String, age: Int, email: String, password: String) {
        sharedPreferences.edit().apply {
            putString("username", username)
            putInt("age", age)
            putString("email", email)
            putString("password", password)
            apply()
        }
    }
}
package com.example.meandroid51.ui.activity

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.meandroid51.R

    class MainActivity : AppCompatActivity() {


        private lateinit var sharedPreferences: SharedPreferences
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)


            sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE)
            setupNavigation(savedInstanceState)


        }

        private fun isRegistered(): Boolean {

            return sharedPreferences.contains("username")
        }

        private fun setupNavigation(savedInstanceState: Bundle?) {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            val navController = navHostFragment.navController
            if (savedInstanceState == null) {
                val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)

                if (isRegistered()) {
                    navGraph.setStartDestination(R.id.user_info)
                    navController.graph = navGraph
                }
            }
        }


    }
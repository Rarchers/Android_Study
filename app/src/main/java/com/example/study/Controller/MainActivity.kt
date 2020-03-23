package com.example.study.Controller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.study.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this,R.id.fragment)
        appBarConfiguration = AppBarConfiguration.Builder(bottomNavigationView.menu).build()
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration)
        NavigationUI.setupWithNavController(bottomNavigationView,navController)

    }
}

package com.example.testproject.ui.activity.main

import android.content.Context
import android.content.Intent
import com.example.testproject.R
import com.example.testproject.databinding.ActivityMainBinding
import com.example.testproject.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun initUI() {}

}

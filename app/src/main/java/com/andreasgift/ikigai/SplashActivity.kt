package com.andreasgift.ikigai

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed(
            { showOnBoardingActivity() }, 3000
        )
    }

    private fun showOnBoardingActivity() {
        startActivity(Intent(this, OnBoardingActivity::class.java))
        finish()
    }
}
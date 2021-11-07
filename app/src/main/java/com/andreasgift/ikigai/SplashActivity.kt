package com.andreasgift.ikigai

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed(
            { showOnBoardingActivity() }, 3000
        )
    }

    private fun showOnBoardingActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
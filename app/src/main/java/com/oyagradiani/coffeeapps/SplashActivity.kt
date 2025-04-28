package com.oyagradiani.coffeeapps

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        sharedPreferences = getSharedPreferences("login_session", MODE_PRIVATE)

        // Delay 2 detik
        Handler(Looper.getMainLooper()).postDelayed({
            checkLoginStatus()
        }, 2000)
    }

    private fun checkLoginStatus() {
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        if (isLoggedIn) {
            // Kalau sudah login, langsung ke HomeActivity
            startActivity(Intent(this, Home::class.java))
        } else {
            // Kalau belum login, ke LoginActivity
            startActivity(Intent(this, LoginActivity::class.java))
        }
        finish()
    }
}

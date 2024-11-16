package com.oyagradiani.coffeeapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Cari tombol berdasarkan ID
        val button = findViewById<TextView>(R.id.button)

        // Set klik listener untuk tombol
        button.setOnClickListener {
            // Buat intent untuk pindah ke HomeActivity
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }
}
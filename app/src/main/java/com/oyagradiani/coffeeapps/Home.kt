package com.oyagradiani.coffeeapps

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.SearchView
import android.widget.TextView

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        // Cari TextView berdasarkan ID
        val textView13 = findViewById<TextView>(R.id.textView13)

        // Set klik listener untuk TextView
        textView13.setOnClickListener {
            // Intent ke DetailActivity
            val intent = Intent(this, Detail::class.java)
            startActivity(intent)
        }
    }
}
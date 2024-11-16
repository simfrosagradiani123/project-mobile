package com.oyagradiani.coffeeapps

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Detail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Inisialisasi ImageView untuk setiap bintang
        val stars = arrayOf(
            findViewById<ImageView>(R.id.star1),
            findViewById<ImageView>(R.id.star2),
            findViewById<ImageView>(R.id.star3),
            findViewById<ImageView>(R.id.star4),
            findViewById<ImageView>(R.id.star5)
        )

        // Tambahkan logika klik untuk setiap bintang
        for (i in stars.indices) {
            stars[i].setOnClickListener {
                // Ubah semua bintang hingga indeks yang diklik menjadi penuh
                for (j in stars.indices) {
                    if (j <= i) {
                        stars[j].setImageResource(R.drawable.star_full) // Bintang penuh
                    } else {
                        stars[j].setImageResource(R.drawable.star_outline) // Bintang kosong
                    }
                }
            }
        }
    }
}

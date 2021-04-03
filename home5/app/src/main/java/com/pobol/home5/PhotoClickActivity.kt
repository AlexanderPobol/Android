package com.pobol.home5

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.pobol.home.R

class PhotoClickActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.photo_click_activity)
        val imgProba = findViewById<ImageView>(R.id.img_auto_click)
        val intent = intent
        if (intent != null) {
            val imgRes = intent.getIntExtra("imageResource", 0)
            imgProba.setImageResource(imgRes)
        }
    }
}
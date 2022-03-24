package com.example.youtubeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main  )

        val btnPlaySingle = findViewById<Button>(R.id.button_single_play)
        val btnMenu = findViewById<Button>(R.id.button_menu)
        print(btnMenu)
        print(btnPlaySingle)
        btnPlaySingle.setOnClickListener(this)
        btnMenu.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val intent = when(view.id){
            R.id.button_single_play -> Intent(this, activity_youtube_api::class.java)
            R.id.button_menu -> Intent(this, MenuActivity::class.java)
            else -> throw IllegalArgumentException("")
        }
        startActivity(intent)
    }
}
package com.example.youtubeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.youtube.player.YouTubeStandalonePlayer
import java.lang.IllegalArgumentException

class MenuActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSingle = findViewById<Button>(R.id.button_video)
        val btnPlayList = findViewById<Button>(R.id.button_list)

        btnSingle.setOnClickListener(this)
        btnPlayList.setOnClickListener(this)

    }

   override fun onClick(view: View){
       val intent = when(view.id){
           R.id.button_video -> YouTubeStandalonePlayer.createVideoIntent(
               this, getString(R.string.GOOGLE_API_KEY), YOUTUBE_VIDEO_ID_KEY)
           R.id.button_list -> YouTubeStandalonePlayer.createPlaylistIntent(
               this, getString(R.string.GOOGLE_API_KEY), PLAYLIST_ID_KEY)
           else -> throw IllegalArgumentException("Invalid button")
       }

       startActivity(intent)
   }

}
package com.example.youtubeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView


const val YOUTUBE_VIDEO_ID_KEY = "1Z6CHioIn3s"

const val PLAYLIST_ID_KEY = "PLgPXFH_SIl7AhYQRFiE3DFjMD9pMz7rDo"

class activity_youtube_api : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {
    val TAG = "YoutubePlayerActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = layoutInflater.inflate(R.layout.activity_youtube_api, null) as ConstraintLayout
        setContentView(layout)

        val playerView = YouTubePlayerView(this)
        playerView.layoutParams = ConstraintLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        layout.addView(playerView)

        playerView.initialize(getString(R.string.GOOGLE_API_KEY), this)
    }

    override fun onInitializationSuccess(
        provider: YouTubePlayer.Provider?,
        player: YouTubePlayer?,
        wasRestored: Boolean
    ) {
        Toast.makeText(this,"Error starting player", Toast.LENGTH_LONG).show()

        player?.setPlaybackEventListener(playbackEventListener)
        player?.setPlayerStateChangeListener(changeStateListener)

        if(!wasRestored){
            player?.cueVideo(YOUTUBE_VIDEO_ID_KEY)
        }
        Log.d(TAG, "onInitializationSuccess")

    }

    override fun onInitializationFailure(
        provider: YouTubePlayer.Provider?,
        youTubeInitializationResult: YouTubeInitializationResult?
    ) {
        val REQUEST_CODE = 0
        if(youTubeInitializationResult?.isUserRecoverableError == true){
            youTubeInitializationResult.getErrorDialog(this, REQUEST_CODE).show()
        }else{
            Toast.makeText(this,"Error starting player", Toast.LENGTH_LONG).show()
        }
        Log.d(TAG, "onInitializationFailure")
    }

    private val playbackEventListener = object : YouTubePlayer.PlaybackEventListener{
        override fun onPlaying() {
            Toast.makeText(this@activity_youtube_api, "Playing", Toast.LENGTH_SHORT).show()
        }

        override fun onPaused() {
            Toast.makeText(this@activity_youtube_api, "Paused", Toast.LENGTH_SHORT).show()
        }

        override fun onStopped() {
        }

        override fun onBuffering(p0: Boolean) {

        }

        override fun onSeekTo(p0: Int) {

        }
    }

    private val changeStateListener = object : YouTubePlayer.PlayerStateChangeListener{
        override fun onLoading() {

        }

        override fun onLoaded(p0: String?) {

        }

        override fun onAdStarted() {
            Toast.makeText(this@activity_youtube_api, "Ad", Toast.LENGTH_SHORT).show()
        }

        override fun onVideoStarted() {

        }

        override fun onVideoEnded() {
            Toast.makeText(this@activity_youtube_api, "Finished", Toast.LENGTH_SHORT).show()
        }

        override fun onError(p0: YouTubePlayer.ErrorReason?) {

        }

    }

}


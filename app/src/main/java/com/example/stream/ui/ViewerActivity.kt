package com.example.stream.ui

import android.os.Bundle
import com.example.stream.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class ViewerActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {
    var youtubeviewer: YouTubePlayerView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewer)
        youtubeviewer = findViewById(R.id.youtubeviewer)
        youtubeviewer?.initialize("AIzaSyBATzbcqD_U_g9E0ochx6FEIUdsts4yn_8",this@ViewerActivity)
    }
    override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, p1: YouTubePlayer?, p2: Boolean) {
        p1?.loadVideo(intent.extras?.getString("tag"))
    }

    override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {

    }

    }


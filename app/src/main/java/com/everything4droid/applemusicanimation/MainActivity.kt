package com.everything4droid.applemusicanimation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.everything4droid.applemusicanimation.adapter.MusicAdapter
import com.everything4droid.applemusicanimation.model.Music

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.container, MusicDetailFragment())
                    .commit()
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)

        val musicList = ArrayList<Music>()

        musicList.add(Music("http://ranchent.com/shaggy/tumblr/images/disco/music-album-intoxicationLg.jpg", "Music1", "Singer1"))
        musicList.add(Music("https://images-na.ssl-images-amazon.com/images/I/811nuTqu-GL._SY355_.jpg", "Music2", "Singer2"))
        musicList.add(Music("http://migrateshop.com/buy2etsy/wp-content/uploads/2016/08/music.jpg", "Music3", "Singer3"))
        musicList.add(Music("https://i.ytimg.com/vi/TpDqwqg7QEE/maxresdefault.jpg", "Music4", "Singer4"))
        musicList.add(Music("http://s3.amazonaws.com/NRNArt/Jane-Lee-Hooker--Spiritus-album-cover.jpg", "Music5", "Singer5"))
        musicList.add(Music("https://akm-img-a-in.tosshub.com/indiatoday/images/video/201209/in-my-city-album-cover_660_091412055052.jpg", "Music6", "Singer6"))
        musicList.add(Music("https://static.webshopapp.com/shops/094126/files/143596814/david-garrett-music-album-cd.jpg", "Music7", "Singer7"))
        musicList.add(Music("http://ranchent.com/shaggy/tumblr/images/disco/music-album-intoxicationLg.jpg", "Music8", "Singer8"))

        val adapter = MusicAdapter(this, musicList) {
            // do stuff onClick
        }

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerView.adapter = adapter

    }
}

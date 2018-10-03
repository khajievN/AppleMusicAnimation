package com.everything4droid.applemusicanimation.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.everything4droid.applemusicanimation.R
import com.everything4droid.applemusicanimation.model.Music
import com.squareup.picasso.Picasso

/**
 * Created by Khajiev Nizomjon on 29/09/2018.
 */
class MusicAdapter(val context: Context,
                   private val musicList: List<Music>,
                   private val listener: (Int) -> Unit) : RecyclerView.Adapter<MusicAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.music_item, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = musicList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(
            music = musicList[position], pos = position, listener = listener)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bind(music: Music, pos: Int, listener: (Int) -> Unit) = with(itemView) {
            val musicName: TextView = findViewById(R.id.musicName)
            val musicImage: ImageView = findViewById(R.id.imageView)
            val singerName: TextView = findViewById(R.id.singerName)
            Picasso.get().load(music.imageUrl).into(musicImage)
            musicName.text = music.musicName
            singerName.text = music.singerNam
            musicImage.setOnClickListener {
                listener(pos)
            }
        }
    }
}
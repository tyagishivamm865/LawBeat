package com.example.lawbeat.NewsAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lawbeat.Models.Data
import com.example.lawbeat.Models.StaticData
import com.example.lawbeat.R

class NewsAdapter(context: Context?,news:List<Data>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEWFIRST = 1
        const val VIEWDEFAULT = 2
    }
    private var context: Context? = context
    var news: List<Data> = news

    private inner class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var textView: TextView = itemView.findViewById(R.id.textView)
        var textView2: TextView = itemView.findViewById(R.id.textView2)
        var imageView2: ImageView = itemView.findViewById(R.id.imageView2)

        fun bind(position: Int) {
            val p = news[position]
            textView.text = p.title
            textView2.text = p.author_name
            context?.let { Glide.with(it).load(p.Image).into(imageView2) }

        }


    }

    private inner class NewsViewHolder2(itemView: View): RecyclerView.ViewHolder(itemView) {
        var textViewDefault: TextView = itemView.findViewById(R.id.textViewDefault)
        var textView2Default: TextView = itemView.findViewById(R.id.textView2Default)
        var imageView2Default: ImageView = itemView.findViewById(R.id.imageView2Default)

        fun bind(position: Int) {
            val p = news[position]
            textViewDefault.text = p.title
            textView2Default.text = p.author_name
            context?.let { Glide.with(it).load(p.Image).into(imageView2Default) }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType== VIEWFIRST){
            return NewsViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.row_first, parent, false)
            )
        }
        else{
            return NewsViewHolder2(
                LayoutInflater.from(parent.context).inflate(R.layout.row_default, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val pos = news[position]
        if(pos.newsTabLayout=== VIEWFIRST) {
            (holder as NewsViewHolder).bind(position)
        }
        else {

            (holder as NewsViewHolder2).bind(position)
        }
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun getItemViewType(position: Int): Int {
        return news[position].newsTabLayout
    }
}
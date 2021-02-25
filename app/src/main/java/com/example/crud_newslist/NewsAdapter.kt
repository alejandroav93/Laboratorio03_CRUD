package com.example.crud_newslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class NewsAdapter(private var noticias: MutableList<News>): RecyclerView.Adapter<NewsAdapter.NewsHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsHolder(view)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val actual: News = this.noticias[position]
        holder.bind(actual)
    }

    override fun getItemCount(): Int {
       return this.noticias.size
    }
    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(noticias: News) = with(itemView){
            val txtTitle: TextView = findViewById(R.id.txtTitle)
            val image: ImageView = findViewById(R.id.Image)
            txtTitle.text = noticias.title

            Picasso.get().load(noticias.image).into(image);
        }
    }
}
package com.example.crud_newslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_newslist.R
import com.example.crud_newslist.News
import com.squareup.picasso.Picasso



class NewsAdapter(private val listener: NewsHolder.ClickListener) :
    RecyclerView.Adapter<NewsAdapter.NewsHolder>() {
    private var noticias: MutableList<News> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsHolder(view)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.bind(noticias[position], listener)
    }

    override fun getItemCount(): Int {
        return noticias.size
    }

    public fun setItems(news: MutableList<News>) {
        noticias = news
        notifyDataSetChanged()
    }

    fun addItem(aux: News) {
        noticias.add(aux)
        notifyItemInserted(itemCount)
    }

    fun removeItem(position: Int) {
        noticias.removeAt(position)
        notifyItemRemoved(position)
    }

    fun updateItem(position: Int, aux: News) {
        noticias[position] = aux
        notifyItemChanged(position)
    }
    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(noticias: News, listener: ClickListener) = with(itemView){
            val txtTitle: TextView = findViewById(R.id.txtTitle)
            val txtDescription: TextView = findViewById(R.id.txtDescription)
            val image: ImageView = findViewById(R.id.Image)
            txtTitle.text = noticias.title
            txtDescription.text = noticias.description
            Picasso.get().load(noticias.image).into(image);

            setOnClickListener {
                listener.onItemClicked(adapterPosition)
            }

            setOnLongClickListener {
                listener.onItemLongClicked(adapterPosition)
            }
        }

        interface ClickListener {

            fun onItemClicked(position: Int)

            fun onItemLongClicked(position: Int): Boolean
        }
    }
}
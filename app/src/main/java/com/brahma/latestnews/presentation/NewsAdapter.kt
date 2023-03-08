package com.brahma.latestnews.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.brahma.latestnews.R
import com.brahma.latestnews.data.model.Article

class NewsAdapter(private val list: List<Article>) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val newsItem = list[position]
        holder.author.text = newsItem.author
        holder.title.text = newsItem.title

    }

    override fun getItemCount(): Int {
        return list.size
    }


    class MyViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val author: AppCompatTextView = itemView.findViewById(R.id.author)
        val title: AppCompatTextView = itemView.findViewById(R.id.title)
    }
}
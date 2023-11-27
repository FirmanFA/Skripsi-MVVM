package com.skripsi.mvvm.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.skripsi.mvvm.R
import com.skripsi.mvvm.data.api.model.GetNewsResponse


class MainAdapter(data: List<GetNewsResponse.Article>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private val data
            : List<GetNewsResponse.Article>

    init {
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.news_card_list_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: GetNewsResponse.Article = data[position]

        // Bind data to your item views
        holder.titleText.text = item.title
        holder.descriptionText.text = item.description

        Glide.with(holder.itemView).load(item.urlToImage).into(holder.itemImage)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var titleText: TextView
        var descriptionText: TextView

        init {
            itemImage = itemView.findViewById(R.id.news_image)
            titleText = itemView.findViewById(R.id.news_title)
            descriptionText = itemView.findViewById(R.id.news_description)
        }
    }
}

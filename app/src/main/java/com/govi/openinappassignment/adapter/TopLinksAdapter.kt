package com.govi.openinappassignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.govi.openinappassignment.R
import com.govi.openinappassignment.models.TopLink

class TopLinksAdapter(var links: List<TopLink>) : RecyclerView.Adapter<TopLinksAdapter.TopLinkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopLinkViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_top_link, parent, false)
        return TopLinkViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TopLinkViewHolder, position: Int) {
        val link = links[position]
        holder.bind(link)
    }

    override fun getItemCount(): Int {
        return links.size
    }

    inner class TopLinkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextViewTop)
        private val urlTextView: TextView = itemView.findViewById(R.id.urlTextViewTop)

        fun bind(link: TopLink) {
            titleTextView.text = link.title
            urlTextView.text = link.web_link
        }
    }
}
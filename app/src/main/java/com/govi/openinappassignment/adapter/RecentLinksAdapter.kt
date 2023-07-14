package com.govi.openinappassignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.govi.openinappassignment.R
import com.govi.openinappassignment.models.RecentLink

class RecentLinksAdapter(var links: List<RecentLink>) : RecyclerView.Adapter<RecentLinksAdapter.RecentLinkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentLinkViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recent_link, parent, false)
        return RecentLinkViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecentLinkViewHolder, position: Int) {
        val link = links[position]
        holder.bind(link)
    }

    override fun getItemCount(): Int {
        return links.size
    }

    inner class RecentLinkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextViewRecent)
        private val urlTextView: TextView = itemView.findViewById(R.id.urlTextViewRecent)

        fun bind(link: RecentLink) {
            titleTextView.text = link.title
            urlTextView.text = link.web_link
        }
    }

}
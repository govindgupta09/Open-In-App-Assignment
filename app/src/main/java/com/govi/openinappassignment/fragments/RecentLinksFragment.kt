package com.govi.openinappassignment.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.govi.openinappassignment.R
import com.govi.openinappassignment.adapter.RecentLinksAdapter
import com.govi.openinappassignment.viewmodels.LinksViewModel

class RecentLinksFragment(private val linksViewModel: LinksViewModel) : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecentLinksAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_recent_links, container, false)

        recyclerView = rootView.findViewById(R.id.recyclerViewRecent)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = RecentLinksAdapter(emptyList())
        recyclerView.adapter = adapter

        // Retrieve recent links data and update the adapter
        linksViewModel.getRecentLinks { links ->
            adapter.links = links
            adapter.notifyDataSetChanged()
        }

        return rootView
    }
}



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
import com.govi.openinappassignment.adapter.TopLinksAdapter
import com.govi.openinappassignment.viewmodels.LinksViewModel

class TopLinksFragment(private val linksViewModel: LinksViewModel) : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TopLinksAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_top_links, container, false)

        recyclerView = rootView.findViewById(R.id.recyclerViewTop)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = TopLinksAdapter(emptyList())
        recyclerView.adapter = adapter

        // Retrieve top links data and update the adapter
        linksViewModel.getTopLinks { links ->
            adapter.links = links
            adapter.notifyDataSetChanged()
        }

        return rootView
    }
}









//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ArrayAdapter
//import android.widget.ListView
//import androidx.fragment.app.Fragment
//import com.govi.openinappassignment.R
//import com.govi.openinappassignment.viewmodels.LinksViewModel
//
//class TopLinksFragment(private val linksViewModel: LinksViewModel) : Fragment() {
//    private lateinit var listView: ListView
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val rootView = inflater.inflate(R.layout.fragment_links, container, false)
//
//        listView = rootView.findViewById(R.id.listView)
//
//        // Retrieve top links data and update ListView
//        linksViewModel.getTopLinks { links ->
//            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, links)
//            listView.adapter = adapter
//            adapter.notifyDataSetChanged()  // Notify the adapter about the data change
//        }
//
//        return rootView
//    }
//}
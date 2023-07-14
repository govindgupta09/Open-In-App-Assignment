package com.govi.openinappassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.govi.openinappassignment.adapter.PagerAdapter
import com.govi.openinappassignment.fragments.RecentLinksFragment
import com.govi.openinappassignment.fragments.TopLinksFragment
import com.govi.openinappassignment.viewmodels.ChartViewModel
import com.govi.openinappassignment.viewmodels.GreetingsViewModel
import com.govi.openinappassignment.viewmodels.LinksViewModel
import com.govi.openinappassignment.viewmodels.NameViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var greetingViewModel: GreetingsViewModel
    private lateinit var nameViewModel: NameViewModel
    private lateinit var chartViewModel: ChartViewModel
    private lateinit var linksViewModel: LinksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // (1) To Display Greeting Messsage according to local Time
        greetingViewModel = ViewModelProvider(this).get(GreetingsViewModel::class.java)

        // (2) To display name from the API
        nameViewModel = ViewModelProvider(this).get(NameViewModel::class.java)

        // (3) To Display Line Chart from the API
        chartViewModel = ViewModelProvider(this).get(ChartViewModel::class.java)

        // (4) To display Top links & Recent links
        linksViewModel = ViewModelProvider(this).get(LinksViewModel::class.java)


        // Set up ViewPager and Tabs
        val pagerAdapter = PagerAdapter(supportFragmentManager)

        // Create instances of the fragments and pass the ViewModel instances
        val topLinksFragment = TopLinksFragment(linksViewModel)
        val recentLinksFragment = RecentLinksFragment(linksViewModel)

        pagerAdapter.addFragment(topLinksFragment, "Top Links")
        pagerAdapter.addFragment(recentLinksFragment, "Recent Links")

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = pagerAdapter

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)
    }
}



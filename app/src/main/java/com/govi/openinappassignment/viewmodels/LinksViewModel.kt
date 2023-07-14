package com.govi.openinappassignment.viewmodels

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import com.govi.openinappassignment.api.DashboardService
import com.govi.openinappassignment.api.RetrofitHelper
import com.govi.openinappassignment.models.DashboardList
import com.govi.openinappassignment.models.RecentLink
import com.govi.openinappassignment.models.TopLink
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LinksViewModel : ViewModel() {
    private val apiService = RetrofitHelper.getInstance().create(DashboardService::class.java)

    fun getTopLinks(callback: (List<TopLink>) -> Unit) {
        // Make API call to retrieve top links data
        val call = apiService.getTopLinks()
        call.enqueue(object : Callback<DashboardList> {
            override fun onResponse(call: Call<DashboardList>, response: Response<DashboardList>) {
                if (response.isSuccessful) {
                    val topLinksResponse = response.body()
                    val topLinks = topLinksResponse?.data?.top_links ?: emptyList()
                    callback(topLinks)
                }
            }

            override fun onFailure(call: Call<DashboardList>, t: Throwable) {
                // Handle failure
                Log.e(ContentValues.TAG, "API call failed: ${t.message}")
            }
        })
    }

    fun getRecentLinks(callback: (List<RecentLink>) -> Unit) {
        // Make API call to retrieve recent links data
        val call = apiService.getRecentLinks()
        call.enqueue(object : Callback<DashboardList> {
            override fun onResponse(call: Call<DashboardList>, response: Response<DashboardList>) {
                if (response.isSuccessful) {
                    val recentLinksResponse = response.body()
                    val recentLinks = recentLinksResponse?.data?.recent_links ?: emptyList()
                    callback(recentLinks)
                }
            }

            override fun onFailure(call: Call<DashboardList>, t: Throwable) {
                // Handle failure
            }
        })
    }
}



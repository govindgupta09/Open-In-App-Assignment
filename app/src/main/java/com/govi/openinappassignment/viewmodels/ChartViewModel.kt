package com.govi.openinappassignment.viewmodels

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import com.govi.openinappassignment.api.DashboardService
import com.govi.openinappassignment.api.RetrofitHelper
import com.govi.openinappassignment.models.DashboardList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChartViewModel : ViewModel() {
    private val apiService = RetrofitHelper.getInstance().create(DashboardService::class.java)

    fun getChartData(callback: (List<Int>) -> Unit) {
        val call = apiService.getChartBoard()
        call.enqueue(object : Callback<DashboardList> {
            override fun onResponse(call: Call<DashboardList>, response: Response<DashboardList>) {
                if (response.isSuccessful) {
                    val dashboardList = response.body()
                    val chartData = dashboardList?.data?.overall_url_chart?.getChartData() ?: emptyList()
                    callback(chartData)
                }
            }

            override fun onFailure(call: Call<DashboardList>, t: Throwable) {
                // Handle failure
                Log.e(TAG, "API call failed: ${t.message}")
            }
        })
    }
}


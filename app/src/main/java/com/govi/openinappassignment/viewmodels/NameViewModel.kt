package com.govi.openinappassignment.viewmodels

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import com.govi.openinappassignment.api.DashboardService
import com.govi.openinappassignment.api.RetrofitHelper
import com.govi.openinappassignment.models.DashboardList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NameViewModel : ViewModel(){
    private val apiService = RetrofitHelper.getInstance().create(DashboardService::class.java)

    fun getName(callback : (String) -> Unit ){
        val call = apiService.getName()
        call.enqueue(object : Callback<DashboardList> {
            override fun onResponse(call: Call<DashboardList>, response: Response<DashboardList>){
                if(response.isSuccessful){
                    val dashboardList = response.body()
                    val name = dashboardList?.name ?: ""
                    callback(name)
                }
            }
            override fun onFailure(call: Call<DashboardList>, t: Throwable) {
                // Handle failure
                Log.e(ContentValues.TAG, "API call failed: ${t.message}")
            }
        })
    }
}


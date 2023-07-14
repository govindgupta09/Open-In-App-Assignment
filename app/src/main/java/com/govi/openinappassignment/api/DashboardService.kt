package com.govi.openinappassignment.api

import com.govi.openinappassignment.models.DashboardList
import retrofit2.Call
import retrofit2.http.GET

interface DashboardService {

    @GET("dashboardNew")
    fun getName() : Call<DashboardList>

    @GET("dashboardNew")
    fun getChartBoard() : Call<DashboardList>

    @GET("dashboardNew")
    fun getTopLinks(): Call<DashboardList>

    @GET("dashboardNew")
    fun getRecentLinks() : Call<DashboardList>

}
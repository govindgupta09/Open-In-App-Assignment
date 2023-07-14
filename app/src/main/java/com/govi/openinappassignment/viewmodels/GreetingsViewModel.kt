package com.govi.openinappassignment.viewmodels

import androidx.lifecycle.ViewModel
import com.govi.openinappassignment.api.DashboardService
import com.govi.openinappassignment.api.RetrofitHelper
import com.govi.openinappassignment.models.GreetingModel

class GreetingsViewModel : ViewModel() {

//    private val apiService = RetrofitHelper.getInstance().create(DashboardService::class.java)

    private val greetingModel = GreetingModel()
    fun getGreetingMessage() : String{
        return greetingModel.getGreetingMessage()
    }
}

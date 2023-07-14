package com.govi.openinappassignment.models

import java.util.*

class GreetingModel {
    fun getGreetingMessage(): String {
        val currentTime = Calendar.getInstance()

        // Determine the appropriate greeting based on the hour
        return when (currentTime.get(Calendar.HOUR_OF_DAY)) {
            in 0..11 -> "Good morning"
            in 12..15 -> "Good afternoon"
            in 16..20 -> "Good evening"
            else -> "Good night"
        }
    }
}
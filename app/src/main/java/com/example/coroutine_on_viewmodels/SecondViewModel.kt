package com.example.coroutine_on_viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class SecondViewModel: ViewModel() {

    private val TAG: String = "SecondViewModel"
    private lateinit var job: Job

    fun load() {

        // Achievable with init too
        if (!::job.isInitialized  || !job.isActive)
            job = viewModelScope.launch {

                Log.d(TAG, "SecondViewModel Launch coroutine")
                repeat(1_000_000) {
                    Log.d("Timer : ", it.toString())
                    delay(1000)
                }
            }
    }

}
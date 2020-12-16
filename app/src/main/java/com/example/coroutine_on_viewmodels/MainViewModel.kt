package com.example.coroutine_on_viewmodels

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.*
import java.net.URL

class MainViewModel: ViewModel() {

    private val TAG: String = "MainViewModel"
    var text : LiveData<String>

    init {
       text = liveData {
            Log.d(TAG, "Launch coroutine")
            emit(fetchDocs())
        }
    }


    // Dispatchers.Main
    private suspend fun fetchDocs() : String{
        // Dispatchers.Main
        var result = ""

        try {
            result =  get("https://developer.android.com/")
        } catch (e: IndexOutOfBoundsException) {
            Log.d("Error","Caught ArithmeticException")
        }


        // Dispatchers.Main
        return result
    }

    suspend fun get(url: String): String {
        // Dispatchers.Main

        var result: String
        withContext(Dispatchers.IO){

            // Very Long task
            result = URL(url).readText()
            delay(3000)

        }
        // Dispatchers.Main
        return result
    }
}
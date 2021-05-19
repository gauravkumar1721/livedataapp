package com.example.myappliv

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.myappliv.RecyclerList as RecyclerList1

class RetroService {
    @GET("repositories")
    abstract fun getDataFromAPI(@Query("q")query : String): Call<RecyclerList1>

}
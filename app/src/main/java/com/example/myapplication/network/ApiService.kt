package com.example.myapplication.network

import com.example.myapplication.data.models.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("shows")
    suspend fun getApiResponse(@Query("page") page:Int) : ResponseModel
}
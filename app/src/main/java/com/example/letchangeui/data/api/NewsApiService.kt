package com.example.letchangeui.data.api

import com.example.letchangeui.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/everything")
    suspend fun getTopHeadlines(
        @Query("q") country: String,
        @Query("apiKey") apiKey: String
    ) : NewsResponse
}
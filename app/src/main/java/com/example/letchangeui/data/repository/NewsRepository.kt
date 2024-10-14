package com.example.letchangeui.data.repository

import android.util.Log
import com.example.letchangeui.data.api.NewsApiService
import com.example.letchangeui.data.model.NewsResponse
import com.example.letchangeui.utils.Constants

class NewsRepository(private val newsApiService: NewsApiService) {

    suspend fun getTopHeadLines(country: String) : NewsResponse{
        Log.d("NewsRepository", "getTopHeadLines:  $country ")
        return newsApiService.getTopHeadlines(country, Constants.API_KEY)
    }
}
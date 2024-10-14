package com.example.letchangeui.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.letchangeui.data.model.Article
import com.example.letchangeui.data.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(private val repository: NewsRepository) : ViewModel() {

    // MutableLiveData to store news articles
    private val _newsList = MutableLiveData<List<Article>>()
    val newsList: LiveData<List<Article>> get() = _newsList


    fun getTopHeadLines(country: String){
        try {
            viewModelScope.launch {
                val newsResponse = repository.getTopHeadLines(country)
                _newsList.value = newsResponse.articles
            }
        } catch (e: Exception) {
            Log.e("NewsViewModel", "Error fetching headlines: ${e.message}", e)
        }
    }
}
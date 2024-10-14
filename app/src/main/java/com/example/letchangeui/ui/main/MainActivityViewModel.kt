package com.example.letchangeui.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainActivityViewModel : ViewModel() {
    val searchQuery = MutableLiveData<String>()

    fun setQuery(query: String) {
        searchQuery.value = query
    }
}

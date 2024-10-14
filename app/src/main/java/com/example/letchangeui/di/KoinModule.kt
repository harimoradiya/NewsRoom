package com.example.letchangeui.di

import com.example.letchangeui.data.api.NewsApiService
import com.example.letchangeui.data.repository.NewsRepository
import com.example.letchangeui.ui.main.NewsViewModel
import com.example.letchangeui.utils.Constants
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApiService::class.java)
    }
}

val repositoryModule = module {
    single { NewsRepository(get()) }
}

val viewModelModule = module {
    viewModel { NewsViewModel(get()) }
}
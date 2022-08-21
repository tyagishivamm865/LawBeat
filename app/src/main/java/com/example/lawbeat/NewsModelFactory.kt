package com.example.lawbeat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lawbeat.repository.NewsRepository
import com.example.lawbeat.viewmodel.NewsViewModel

class NewsModelFactory(private val repository: NewsRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(repository) as T
    }
}
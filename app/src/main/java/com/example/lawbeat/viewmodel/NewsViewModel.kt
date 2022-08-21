package com.example.lawbeat.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lawbeat.Models.NewsData
import com.example.lawbeat.Models.Resource
import com.example.lawbeat.repository.NewsRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(private val newsRepository: NewsRepository):ViewModel() {
    val userData: MutableLiveData<Resource<NewsData>> = MutableLiveData()

    fun getUsers(tid: Int) = viewModelScope.launch {
//        userData.postValue(Resource.Loading())
        val response = newsRepository.getNews(tid)

        userData.postValue(handleUserResponse(response))
    }
    private fun handleUserResponse(response: Response<NewsData>): Resource<NewsData> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())

    }




}
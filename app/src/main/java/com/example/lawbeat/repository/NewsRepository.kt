package com.example.lawbeat.repository

import com.example.lawbeat.NewsApi.ApiInterface

class NewsRepository() {
    private val retrofitService by lazy {
        ApiInterface.getInstance().create(ApiInterface::class.java)
    }



    suspend fun getNews(tid: Int) = retrofitService.getNews(10, 1, tid)
}
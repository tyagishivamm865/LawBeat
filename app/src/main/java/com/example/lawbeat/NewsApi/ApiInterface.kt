package com.example.lawbeat.NewsApi

import com.example.lawbeat.Models.NewsData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("lawbeat-news-details")
    suspend fun getNews(
        @Query("items_per_page") items_per_page: Int = 50,
        @Query("page") page: Int = 1,
        @Query("tid") tid: Int
    ): Response<NewsData>
}
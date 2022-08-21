package com.example.lawbeat.NewsApi

import com.example.lawbeat.Models.NewsData
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("lawbeat-news-details")
    suspend fun getNews(
        @Query("items_per_page") items_per_page: Int = 50,
        @Query("page") page: Int = 1,
        @Query("tid") tid: Int
    ): Response<NewsData>

    companion object {

        var retrofitService: Retrofit? = null

        //Create the Retrofit service instance using the retrofit.
        fun getInstance(): Retrofit {

            if (retrofitService == null) {
                retrofitService = Retrofit.Builder()
                    .baseUrl("http://lawgical.php-dev.in/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofitService!! as Retrofit
        }
    }
}

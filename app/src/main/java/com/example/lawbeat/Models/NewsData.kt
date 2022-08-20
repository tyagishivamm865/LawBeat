package com.example.lawbeat.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NewsData(
    @Expose
    @SerializedName("data")
    val data: List<Data>,
    @Expose
    @SerializedName("message")
    val message: String,
    @Expose
    @SerializedName("pager")
    val pager: List<Pager>,
    @Expose
    @SerializedName("statusCode")
    val statusCode: Int
)
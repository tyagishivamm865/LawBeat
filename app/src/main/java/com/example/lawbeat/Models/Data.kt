package com.example.lawbeat.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data(
    @Expose
    @SerializedName("Date")
    val Date: String,
    @Expose
    @SerializedName("Image")
    val Image: String,
    @Expose
    @SerializedName("Raw_Date")
    val Raw_Date: String,
    @Expose
    @SerializedName("author_info")
    val author_info: List<AuthorInfo>,
    @Expose
    @SerializedName("author_logo")
    val author_logo: Any,
    @Expose
    @SerializedName("author_name")
    val author_name: String,
    @Expose
    @SerializedName("body")
    val body: String,
    @Expose
    @SerializedName("bookmark")
    val bookmark: Int,
    @Expose
    @SerializedName("category")
    val category: String,
    @Expose
    @SerializedName("category_name")
    val category_name: String,
    @Expose
    @SerializedName("event_link")
    val event_link: String,
    @Expose
    @SerializedName("file_button_title")
    val file_button_title: Any,
    @Expose
    @SerializedName("files")
    val files: String,
    @Expose
    @SerializedName("is_event")
    val is_event: Int,
    @Expose
    @SerializedName("nid")
    val nid: String,
    @Expose
    @SerializedName("other_images")
    val other_images: Any,
    @Expose
    @SerializedName("pinstory")
    val pinstory: Int,
    @Expose
    @SerializedName("premium")
    val premium: String,
    @Expose
    @SerializedName("reading_time")
    val reading_time: String,
    @Expose
    @SerializedName("source_field")
    val source_field: Any,
    @Expose
    @SerializedName("synopsis")
    val synopsis: Any,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("video_url")
    val video_url: Any,
    @Expose
    @SerializedName("view_node")
    val view_node: String
)
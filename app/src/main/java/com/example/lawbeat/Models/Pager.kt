package com.example.lawbeat.Models

data class Pager(
    val current_page: Int,
    val items_per_page: Int,
    val total_items: Int,
    val total_pages: Int
)
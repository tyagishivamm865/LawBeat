package com.example.lawbeat

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.lawbeat.Models.TabEntity
import com.example.lawbeat.NewsAdapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
   lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById<TabLayout>(R.id.tablayout)
        viewPager = findViewById<ViewPager2>(R.id.viewpager)

        val tabs = listOf(TabEntity(1,"LATEST NEWS"),TabEntity(2,"NEWS UPDATE"),TabEntity(3,"COLOUMNS"),TabEntity(4,"BAR SPEAKS"),TabEntity(5,"ARTICLES"),TabEntity(6,"EVENT CORNER"),TabEntity(7,"VIDEOS"))
        viewPager.adapter = ViewPagerAdapter(this,tabs)
        TabLayoutMediator(tabLayout,viewPager){tab,position ->
            tab.text = tabs.get(position).tab
        }.attach()

    }
}
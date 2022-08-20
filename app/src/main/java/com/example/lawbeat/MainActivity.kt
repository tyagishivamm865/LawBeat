package com.example.lawbeat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.lawbeat.NewsAdapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById<TabLayout>(R.id.tablayout)
        viewPager = findViewById<ViewPager>(R.id.viewpager)

        tabLayout!!.addTab(tabLayout!!.newTab().setText("TOP STORIES"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("NEWS UPDATES"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("COLUMNS"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("BAR SPEAKS"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("ARTICLES"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("EVENT CORNER"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("VIDEOS"))


        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = ViewPagerAdapter(this, supportFragmentManager, tabLayout!!.tabCount)
        viewPager!!.adapter = adapter

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

    }
}
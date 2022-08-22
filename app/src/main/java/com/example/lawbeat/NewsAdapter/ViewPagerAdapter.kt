package com.example.lawbeat.NewsAdapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lawbeat.MainActivity
import com.example.lawbeat.Models.TabEntity
import com.example.lawbeat.NewsFragment
import java.util.*

class ViewPagerAdapter(private val mainActivity: MainActivity,val tabs:List<TabEntity>) : FragmentStateAdapter(mainActivity) {
    override fun getItemCount(): Int {
        return tabs.size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = NewsFragment()
        fragment.arguments= Bundle().apply {
            putInt("tid",tabs.get(position).tid)

        }
        return fragment

    }


}
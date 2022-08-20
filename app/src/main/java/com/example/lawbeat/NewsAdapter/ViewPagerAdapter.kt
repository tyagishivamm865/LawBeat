package com.example.lawbeat.NewsAdapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.lawbeat.NewsFragment

class ViewPagerAdapter(private val context: Context, fragmentmanager: FragmentManager, internal var total: Int) : FragmentPagerAdapter(fragmentmanager) {


    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return NewsFragment()
            }

            else -> return NewsFragment()
        }
    }

    override fun getCount(): Int {
        return total
    }
}
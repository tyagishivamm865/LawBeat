package com.example.lawbeat

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lawbeat.Models.Data
import com.example.lawbeat.Models.NewsData
import com.example.lawbeat.Models.Resource
import com.example.lawbeat.Models.StaticData
import com.example.lawbeat.NewsAdapter.NewsAdapter
import com.example.lawbeat.repository.NewsRepository
import com.example.lawbeat.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.properties.Delegates


class NewsFragment : Fragment() {
    lateinit var viewModel: NewsViewModel
    lateinit var userAdapter: NewsAdapter
    val myviewModel: NewsViewModel by viewModels()
    private var tid by Delegates.notNull<Int>()


    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        val tid = arguments?.getInt("tid")?:1


        val dataRepo = NewsRepository()
        viewModel =
            ViewModelProvider(this, NewsModelFactory(dataRepo)).get(NewsViewModel::class.java)


        val job = lifecycleScope.launchWhenCreated {
                viewModel.getUsers(tid)
        }

        Log.d("fetch", job.toString())



        viewModel.userData.observe(viewLifecycleOwner, Observer
        { response ->
            Log.d("response", response.data?.message.toString())
            when (response) {
                is Resource.Success -> {

                    response.data?.let { userResponse ->
                        userAdapter = NewsAdapter(context, userResponse.data)
                        recyclerview.adapter = userAdapter
                        recyclerview.layoutManager = LinearLayoutManager(context)
                    }
                }
                is Resource.Error -> {

                    response.message?.let {
                        Log.e("usermessage", "An error occured:$it")
                    }
                }

                else -> {
                    Log.e("loading", "Loading heavily")
                }
            }

        })


    }
}






//            val tid = requireArguments().getInt("position")






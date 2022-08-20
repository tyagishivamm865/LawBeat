package com.example.lawbeat

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lawbeat.Models.StaticData
import com.example.lawbeat.NewsAdapter.NewsAdapter
import com.example.lawbeat.NewsApi.RetrofitInstance
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch(Dispatchers.IO) {
            val result = RetrofitInstance.api.getNews(50,1,3)
            if (result != null)
            // Checking the results
                Log.d("ayush: ", result.body().toString())
        }

        val dataList = ArrayList<StaticData>()
        dataList.add(StaticData(NewsAdapter.VIEWFIRST, "CBI raids over 20 places , including Sisodia's house",R.drawable.newws,"John Doe",1))
        dataList.add(StaticData(NewsAdapter.VIEWDEFAULT, "How India's richest sport got a star from its poorest place",R.drawable.rich,"M Smith",2))
        dataList.add(StaticData(NewsAdapter.VIEWDEFAULT, "Mumbai's thriller: Guns might belong to UK security firm",R.drawable.newws,"John Doe",3))
        dataList.add(StaticData(NewsAdapter.VIEWDEFAULT, "Shahbaz's journey: From most backward district to Team India",R.drawable.ic_baseline_image_24,"M Smith",4))
        dataList.add(StaticData(NewsAdapter.VIEWDEFAULT, "Paytm CEO faces biggest test since IPO dud",R.drawable.ic_baseline_image_24,"John Doe",5))
        dataList.add(StaticData(NewsAdapter.VIEWDEFAULT, "Punjabi 4th most spoken language in Canada",R.drawable.ic_baseline_image_24,"M Smith",6))
        dataList.add(StaticData(NewsAdapter.VIEWDEFAULT, "3 conversations I had in 'new' Kashmir",R.drawable.ic_baseline_image_24,"John Doe",7))


        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerview)
        recyclerview.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = NewsAdapter(context?.applicationContext,dataList)
        recyclerView.adapter = adapter


    }



}
package com.brahma.latestnews.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.brahma.latestnews.MainActivity
import com.brahma.latestnews.R
import com.brahma.latestnews.data.model.Article
import com.brahma.latestnews.data.util.Resource
import com.brahma.latestnews.databinding.NewsFragmentBinding
import com.brahma.latestnews.presentation.viewModel.NewsViewModel


class NewsFragment : Fragment() {

    private lateinit var viewModel: NewsViewModel
    private lateinit var newsFragmentBinding: NewsFragmentBinding
    private lateinit var adapter: NewsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.news_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsFragmentBinding = NewsFragmentBinding.bind(view)
        newsFragmentBinding.root
        viewModel = (activity as MainActivity).viewModel

        // this creates a vertical layout Manager
        newsFragmentBinding.recyclerView.layoutManager = LinearLayoutManager(activity)

        newsList()
    }

    private fun newsList() {
        viewModel.getNewsHeadLines("in", 1)

        viewModel.newsHeadLines.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Loading -> {
                    Toast.makeText(activity, "Loading.....", Toast.LENGTH_LONG).show()
                }
                is Resource.Success -> {
                    response.data?.let {
                        Toast.makeText(activity, "Success.....", Toast.LENGTH_LONG).show()
                        showRecyclerView(it.articles.toList())
                    }
                }
                is Resource.Error -> {
                    response.message?.let {
                        Toast.makeText(activity, "error occurred $it", Toast.LENGTH_LONG).show()
                    }
                }
            }

        })
    }

    private fun showRecyclerView(list: List<Article>) {
        adapter = NewsAdapter(list)
        newsFragmentBinding.recyclerView.adapter = adapter
    }
}
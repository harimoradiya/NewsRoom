package com.example.letchangeui.ui.main.frags

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.activityViewModels

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.letchangeui.R
import com.example.letchangeui.data.model.Article
import com.example.letchangeui.ui.main.MainActivityViewModel
import com.example.letchangeui.ui.main.NewsViewModel
import com.example.letchangeui.ui.main.adapters.NewsAdapter
import com.example.letchangeui.utils.NetworkUtils
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {


    // Inject the ViewModel
    private val newsViewModel: NewsViewModel by viewModel()
    private lateinit var newsAdapter: NewsAdapter
    private var articlesList: MutableList<Article> = mutableListOf()
    private lateinit var recyclerView: RecyclerView
    private lateinit var pb_home: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private val mainActivityViewModel: MainActivityViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        pb_home = view.findViewById(R.id.pb_home)


        return view
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        if (NetworkUtils.isNetworkAvailable(context ?: requireContext())) {
            observeViewModel()


            // Fetch news data only if LiveData is null or empty
            if (newsViewModel.newsList.value.isNullOrEmpty()) {
                newsViewModel.getTopHeadLines("india")
            }

            mainActivityViewModel.searchQuery.observe(viewLifecycleOwner) { query ->
                updateNewsWithQuery(query)
            }

        } else {

            pb_home.visibility = View.GONE
            recyclerView.visibility = View.GONE
            showNoInternetDialog(context ?: requireContext())
        }

    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        recyclerView.layoutManager = LinearLayoutManager(context ?: requireContext())
        recyclerView.adapter = newsAdapter

    }

    private fun observeViewModel() {
        pb_home.visibility = View.VISIBLE

        newsViewModel.newsList.observe(viewLifecycleOwner) { articles ->
            if (articles != null && articles.isNotEmpty()) {

                articles.let {
                    articlesList.clear()
                    articlesList.addAll(articles)
                    newsAdapter.setNewsData(articlesList)
                    pb_home.visibility = View.GONE
                    recyclerView.visibility = View.VISIBLE
                }
            } else {
                pb_home.visibility = View.GONE
                Log.d("HomeFragment", "observeViewModel: Error while fetching the data")

            }

        }

    }

    fun updateNewsWithQuery(query: String) {
        // Use the query to load data
        if (isAdded) {
            // Fetch news data based on the new query only if the fragment is still attached
            newsViewModel.getTopHeadLines(query)
        } else {
            Log.d("HomeFragment", "Fragment is not attached, cannot update ViewModel.")
        }

    }


    fun showNoInternetDialog(context: Context) {
        MaterialAlertDialogBuilder(context)
            .setTitle("No Internet Connection")
            .setMessage("Please check your internet connection and try again.")
            .setPositiveButton("Retry") { dialog, _ ->
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }


    companion object {

    }
}
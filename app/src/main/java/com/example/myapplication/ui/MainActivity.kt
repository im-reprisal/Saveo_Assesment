package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.adapter.MainAdapter
import com.example.myapplication.ui.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var mainAdapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        /**
         * starting the shimmer effect
         */
        binding.shimmerFrameLayout.startShimmerAnimation()

        setAdapter()

        /**
         * observing each data inside the list using live data
         */
        mainViewModel.showMovieList().observe(
            this,{
                it?.let {
                    CoroutineScope(Main).launch {
                        binding.recyclerView.visibility = View.VISIBLE
                        mainAdapter.submitData(it)
                    }
                }
            }
        )
    }
    /**
     * setting all the movie in recyclerview
     */
    private fun setAdapter() {
        mainAdapter = MainAdapter(this)
        val linearLayoutManager = GridLayoutManager(this, 3)
        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            this.adapter = mainAdapter
        }
    }
}
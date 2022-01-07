package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.ui.adapter.MainAdapter
import com.example.myapplication.ui.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var mainAdapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setAdapter()
        mainViewModel.searchMovieList().observe(
            this,{
                it?.let {
                    CoroutineScope(Main).launch {
                        mainAdapter.submitData(it)
                    }
                }
            }
        )
    }

    private fun setAdapter() {
        mainAdapter = MainAdapter()
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.apply {
            layoutManager = linearLayoutManager
            this.adapter = mainAdapter
        }
    }
}
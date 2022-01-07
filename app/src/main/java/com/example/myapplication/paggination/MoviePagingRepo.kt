package com.example.myapplication.paggination

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData

class MoviePagingRepo {
    fun getPagesList() = Pager(
        config = PagingConfig(
            pageSize = 20
        ),
        pagingSourceFactory = { MoviePagingSource() }
    ).liveData
}
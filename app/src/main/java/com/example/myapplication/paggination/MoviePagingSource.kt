package com.example.myapplication.paggination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.myapplication.data.models.ResponseModel
import com.example.myapplication.data.models.ResponseModelItem
import com.example.myapplication.network.ServiceGenerator

class MoviePagingSource:PagingSource<Int,ResponseModelItem>() {
    private val apiClient = ServiceGenerator.getApiService()

    override fun getRefreshKey(state: PagingState<Int, ResponseModelItem>): Int? {
      return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResponseModelItem> {
        val pageNumber = params.key ?: 1;

        val movieResponse: ResponseModel = apiClient.getApiResponse(pageNumber)
        val tvMovieResponseItem: ArrayList<ResponseModelItem> = movieResponse
        return try {
            LoadResult.Page(data = tvMovieResponseItem,prevKey = null,nextKey = if (tvMovieResponseItem.isEmpty()) null else pageNumber + 1)
        }
        catch (e:Exception){
            LoadResult.Error(e)
        }
    }
}
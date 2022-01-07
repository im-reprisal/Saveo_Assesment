package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.paggination.MoviePagingRepo

class MainViewModel:ViewModel() {

    private val peopleRepo = MoviePagingRepo()

    fun searchMovieList() = peopleRepo.getPagesList()
}
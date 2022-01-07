package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.data.models.ResponseModelItem
import com.example.myapplication.databinding.ActivityDetailsBinding
import org.jsoup.Jsoup

class DetailsActivity : AppCompatActivity() {
    lateinit var binding : ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_details)

        val name = intent?.getStringExtra("name")
        val generes1 = intent?.getStringExtra("generes1")
        val generes2 = intent?.getStringExtra("generes2")
        val generes3 = intent?.getStringExtra("generes3")
        val launch = intent?.getStringExtra("launch")
        val rating = intent?.getStringExtra("rating")
        val imdb = intent?.getStringExtra("imdb")
        val summary = intent?.getStringExtra("summary")
        Glide.with(this).load(intent.getStringExtra("imgUrl")).into(binding.ivMovieThumbnail)
        binding.tvMovieName.text = name
        binding.tvTime.text = launch
        binding.tvRatings.text = "RatingModel(average = $rating)"
        binding.tvReview.text = "imdb : $imdb"
        binding.tvSynopsisData.text = summary
    }
}
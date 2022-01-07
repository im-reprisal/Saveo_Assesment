package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebChromeClient
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityShowMoreDetailsBinding

class ShowMoreDetailsActivity : AppCompatActivity() {

    lateinit var binding : ActivityShowMoreDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_show_more_details)
        val url = intent?.getStringExtra("newUrl")
        Log.d("adi","$url")
        binding.webView.apply {
            webChromeClient= WebChromeClient()
            if (url != null) {
                loadUrl(url)
            }
        }
    }
}
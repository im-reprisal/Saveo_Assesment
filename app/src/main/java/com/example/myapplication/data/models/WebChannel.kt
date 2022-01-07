package com.example.myapplication.data.models


import com.google.gson.annotations.SerializedName

data class WebChannel(
    @SerializedName("country")
    val country: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)
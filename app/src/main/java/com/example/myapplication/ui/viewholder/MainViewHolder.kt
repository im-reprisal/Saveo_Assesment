package com.example.myapplication.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.data.models.ResponseModelItem
import kotlinx.android.synthetic.main.item_layout.view.*


class MainViewHolder(private val view: View):RecyclerView.ViewHolder(view) {
    fun setData(movieResponseItem: ResponseModelItem){
        view.apply {
            Glide.with(this).load(movieResponseItem.image.medium).into(ivImgShow)
        }
    }
}
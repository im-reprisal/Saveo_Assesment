package com.example.myapplication.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.data.models.ResponseModelItem
import kotlinx.android.synthetic.main.item_layout.view.*


class MainViewHolder(private val view: View):RecyclerView.ViewHolder(view) {
    fun setData(peopleResponseItem: ResponseModelItem){
        view.apply {
            Glide.with(this).load(peopleResponseItem.image.medium).into(ivImgShow)
        }
    }
}
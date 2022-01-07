package com.example.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.R
import com.example.myapplication.data.models.ResponseModelItem
import com.example.myapplication.ui.viewholder.MainViewHolder

class MainAdapter : PagingDataAdapter<ResponseModelItem, MainViewHolder>(diffUtil){
   companion object{
       val diffUtil = object:DiffUtil.ItemCallback<ResponseModelItem>(){
           override fun areItemsTheSame(
               oldItem: ResponseModelItem,
               newItem: ResponseModelItem
           ): Boolean {
               return oldItem.id == newItem.id
           }

           override fun areContentsTheSame(
               oldItem: ResponseModelItem,
               newItem: ResponseModelItem
           ): Boolean {
              return oldItem.equals(newItem)
           }
       }
   }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val tvPeopleResponseItem = getItem(position)
        tvPeopleResponseItem?.let {
            holder.setData(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MainViewHolder(view)
    }
}
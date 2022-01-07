package com.example.myapplication.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.R
import com.example.myapplication.data.models.ResponseModelItem
import com.example.myapplication.ui.DetailsActivity
import com.example.myapplication.ui.viewholder.MainViewHolder
import kotlinx.android.synthetic.main.item_layout.view.*


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
        val tvMovieResponseItem = getItem(position)
        holder.itemView.apply {
            onClickConstrainLayout.setOnClickListener {
                val intent= Intent(context, DetailsActivity::class.java)
                intent.putExtra("name",tvMovieResponseItem?.name)
                context.startActivity(intent)
            }
        }
        tvMovieResponseItem?.let {
            holder.setData(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val itemLayoutBinding: ItemLayoutBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_layout, parent, false)
//        return MainViewHolder(itemLayoutBinding)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MainViewHolder(view)
    }
}
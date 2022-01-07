package com.example.myapplication.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.data.models.ResponseModelItem
import com.example.myapplication.databinding.AdapterItemLayoutBinding
import com.example.myapplication.ui.DetailsActivity
import org.jsoup.Jsoup

class MainAdapter(private val context: Context) : PagingDataAdapter<ResponseModelItem, MainViewHolder>(diffUtil){
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
        val itemLayoutBinding = holder.adapterItemLayoutBinding as AdapterItemLayoutBinding
        Glide.with(context).load(tvMovieResponseItem?.image?.original).into(itemLayoutBinding.ivImgShow)
        itemLayoutBinding.onClickCardView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("name",tvMovieResponseItem?.name)
            intent.putExtra("generes1",tvMovieResponseItem?.genres?.indexOf("0"))
            intent.putExtra("generes2",tvMovieResponseItem?.genres?.indexOf("1"))
            intent.putExtra("generes3",tvMovieResponseItem?.genres?.indexOf("2"))
            intent.putExtra("launch",tvMovieResponseItem?.premiered)
            intent.putExtra("rating",tvMovieResponseItem?.rating?.average.toString())
            intent.putExtra("imdb",tvMovieResponseItem?.externals?.imdb.toString())
            intent.putExtra("imgUrl",tvMovieResponseItem?.image?.original)
            intent.putExtra("url",tvMovieResponseItem?.url)
            val textFromHtml: String = Jsoup.parse(tvMovieResponseItem?.summary).text()
            intent.putExtra("summary",textFromHtml)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemLayoutBinding = AdapterItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return MainViewHolder(itemLayoutBinding)
    }
}

class MainViewHolder(val adapterItemLayoutBinding: AdapterItemLayoutBinding): RecyclerView.ViewHolder(adapterItemLayoutBinding.root)
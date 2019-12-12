package com.example.submission2_dicoding.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submission2_dicoding.R
import com.example.submission2_dicoding.Model.TvShow
import kotlinx.android.synthetic.main.view_model.view.*

class TvShowAdapter(private val showList: List<TvShow>):RecyclerView.Adapter<TvShowAdapter.ShowViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.view_model,parent,false)
        return ShowViewHolder(inflater)
    }
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun getItemCount(): Int = showList.size

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        holder.bind(showList[position])

    }

    inner class ShowViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        fun bind(tvshow: TvShow){
            with(itemView){
                Glide.with(itemView.context)
                    .load(tvshow.photo)
                    .apply(RequestOptions().override(550,650))
                    .into(img_photo)

                txt_name.text = tvshow.name

                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(tvshow) }
            }
        }
    }

     interface OnItemClickCallback{
         fun onItemClicked(data: TvShow)
     }
}
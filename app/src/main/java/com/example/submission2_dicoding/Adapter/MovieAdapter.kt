package com.example.submission2_dicoding.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submission2_dicoding.Model.Movie
import com.example.submission2_dicoding.R
import kotlinx.android.synthetic.main.view_model.view.*


class MovieAdapter(private val listMovie:ArrayList<Movie>):RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater =LayoutInflater.from(parent.context).inflate(R.layout.view_model,parent,false)
        return MovieViewHolder(inflater)
    }
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun getItemCount(): Int =listMovie.size


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }


    inner class MovieViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {

        fun bind(movie: Movie){
            with(itemView){
                Glide.with(itemView.context)
                    .load(movie.photo)
                    .apply(RequestOptions().override(550,600))
                    .into(img_photo)

                txt_name.text = movie.name
                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(movie) }

            }
        }

    }
    interface OnItemClickCallback{
        fun onItemClicked(data: Movie)
    }
}
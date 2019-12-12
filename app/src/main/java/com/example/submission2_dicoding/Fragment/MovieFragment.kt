package com.example.submission2_dicoding.Fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.submission2_dicoding.Detail
import com.example.submission2_dicoding.Model.Movie
import com.example.submission2_dicoding.Adapter.MovieAdapter
import com.example.submission2_dicoding.R
import kotlinx.android.synthetic.main.fragment_movie.*

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {

    companion object {
        private val list = ArrayList<Movie>()
        private val mvList = arrayListOf<Movie>()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_movie.setHasFixedSize(true)
        list.addAll(getMovieList())
        showRecycleList()


    }

   private fun getMovieList(): ArrayList<Movie>{
        val dataName = resources.getStringArray(R.array.movie_name)
        val dataDesc = resources.getStringArray(R.array.movie_desc)
        val dataPhoto = resources.obtainTypedArray(R.array.movie_photo)
        val dataRating = resources.getStringArray(R.array.movie_rating)
        val dataDirector = resources.getStringArray(R.array.movie_directors)


        for (position in dataName.indices){
            val movie = Movie(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDesc[position],
                dataRating[position],
                dataDirector[position]
            )
            mvList.add(movie)
        }
        return mvList

    }

    private fun showRecycleList(){
        rv_movie.layoutManager = GridLayoutManager(activity,2)
        val movieAdapter =
            MovieAdapter(list)
        rv_movie.adapter = movieAdapter

        movieAdapter.setOnItemClickCallback(object:
            MovieAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Movie) {

                val intentWithExtraData = Intent(activity, Detail::class.java)
                intentWithExtraData.putExtra(Detail.DATA_MOVIE,data)
                startActivity(intentWithExtraData)

            }

        })
    }
}

package com.example.submission2_dicoding.Fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.submission2_dicoding.Detail
import com.example.submission2_dicoding.R
import com.example.submission2_dicoding.Model.TvShow
import com.example.submission2_dicoding.Adapter.TvShowAdapter
import com.example.submission2_dicoding.DetailShow
import kotlinx.android.synthetic.main.fragment_show.*

/**
 * A simple [Fragment] subclass.
 */
class ShowFragment : Fragment() {
companion object {
    private val list = ArrayList<TvShow>()
    private val showList = arrayListOf<TvShow>()
}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_show.setHasFixedSize(true)
        list.addAll(getMovieList())
        showRecyclyeList()


    }
    fun getMovieList(): ArrayList<TvShow>{
        val dataName = resources.getStringArray(R.array.tv_show_name)
        val dataDesc = resources.getStringArray(R.array.tv_show_description)
        val dataPhoto = resources.obtainTypedArray(R.array.tv_show_photo)
        val dataRating = resources.getStringArray(R.array.tv_show_rating)


        for (position in dataName.indices){
            val show = TvShow(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDesc[position],
                dataRating[position]
            )
            showList.add(show)
        }
        return showList

    }

    private fun showRecyclyeList(){
        rv_show.layoutManager = GridLayoutManager(activity,2)
        val tvShowAdapter =
            TvShowAdapter(list)
        rv_show.adapter = tvShowAdapter

        tvShowAdapter.setOnItemClickCallback(object :
            TvShowAdapter.OnItemClickCallback {
            override fun onItemClicked(data: TvShow) {

                val intentWithExtraData = Intent(activity, DetailShow::class.java)
                intentWithExtraData.putExtra(DetailShow.DATA_SHOW,data)
                startActivity(intentWithExtraData)
                
            }

        })
    }


}

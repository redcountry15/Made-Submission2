package com.example.submission2_dicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import com.example.submission2_dicoding.Model.Movie
import com.example.submission2_dicoding.Model.TvShow
import kotlinx.android.synthetic.main.activity_detail.*

class Detail : AppCompatActivity() {

    companion object{
        const val  DATA_MOVIE = "DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataMovie = intent.getParcelableExtra(DATA_MOVIE) as Movie
                re.text = dataMovie.name
                received_text_description.text = dataMovie.desc
                received_text_director.text = dataMovie.director
                received_text_rating.text = dataMovie.rating
                image_backdrop.setImageResource(dataMovie.photo)
                image_poster.setImageResource(dataMovie.photo)



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_change_settings) {
            val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(mIntent)
        }
        return super.onOptionsItemSelected(item)
    }
}

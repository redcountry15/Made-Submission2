package com.example.submission2_dicoding

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.submission2_dicoding.Model.TvShow
import kotlinx.android.synthetic.main.activity_detail.*

class DetailShow : AppCompatActivity() {

    companion object {
        const val  DATA_SHOW = "DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataShow = intent.getParcelableExtra(DATA_SHOW) as TvShow
        re.text = dataShow.name
        received_text_rating.text = dataShow.rating
        received_text_description.text = dataShow.desc
        image_poster.setImageResource(dataShow.photo)
        image_backdrop.setImageResource(dataShow.photo)
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
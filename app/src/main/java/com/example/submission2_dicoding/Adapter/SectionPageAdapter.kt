package com.example.submission2_dicoding.Adapter

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.submission2_dicoding.Fragment.MovieFragment
import com.example.submission2_dicoding.Fragment.ShowFragment
import com.example.submission2_dicoding.R

class SectionPageAdapter(private val mContext:Context,fm:FragmentManager) : FragmentPagerAdapter (fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    @StringRes
    private val TAB_TITLE  = intArrayOf(
        R.string.movie_title,
        R.string.tv_show_title
    )


    override fun getItem(position: Int): Fragment {
        var fragment:Fragment? = null

        when(position){
            0-> fragment = MovieFragment()
            1-> fragment = ShowFragment()
        }

        return fragment as Fragment

    }

    override fun getPageTitle(position: Int): CharSequence? {
        return  mContext.resources.getString(TAB_TITLE[position])
    }

    override fun getCount(): Int {
        return 2
    }
}
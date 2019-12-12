package com.example.submission2_dicoding.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    var photo:Int,
    var name:String?,
    var desc:String?,
    var rating:String?,
    var director:String?
): Parcelable
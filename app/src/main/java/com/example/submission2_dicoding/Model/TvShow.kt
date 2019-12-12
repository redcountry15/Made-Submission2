package com.example.submission2_dicoding.Model

import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class TvShow (
    var photo:Int,
    var name:String?,
    var desc:String?,
    var rating: String?
): Parcelable
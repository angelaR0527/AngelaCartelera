package com.example.angelacartelera

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// Nos creamos un objeto Movie para las peliculas
@Parcelize
data class Movie (
    var title: String,
    var cover:String,
    var description:String
): Parcelable


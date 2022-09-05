package com.example.data.model

import com.example.domain.model.Movie
import com.google.gson.annotations.SerializedName

data class MovieApi(
    private val id: String,
    private val title: String,
    private val image: String
) {

    fun mapToDomain(): Movie = Movie(
        id = id,
        title = title,
        imageUrl = image,
        rating = 10
    )

}

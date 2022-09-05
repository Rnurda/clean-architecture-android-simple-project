package com.example.data.model

import com.example.data.model.MovieApi

data class MoviesResponse(
    val errorMessage: String,
    val items: List<MovieApi>
)

package com.example.domain.model

data class Movie(
    val id: String,
    val title: String,
    val rating: Int,
    val imageUrl: String
){
    companion object{
        val Movie.veryGoodMovie: Boolean
            get() = title.contains("a") && rating >9
    }
}


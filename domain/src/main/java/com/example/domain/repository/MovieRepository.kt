package com.example.domain.repository

import com.example.domain.model.Movie
import com.example.domain.model.MovieDetail

interface MovieRepository {

    suspend fun getMovies(): List<Movie>

    suspend fun getMovieDetail(): MovieDetail

}
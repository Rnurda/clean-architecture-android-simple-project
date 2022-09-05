package com.example.data.repository

import com.example.data.api.MovieService
import com.example.domain.model.Movie
import com.example.domain.model.MovieDetail
import com.example.domain.repository.MovieRepository
import retrofit2.Retrofit

class MovieRepositoryImpl(
    private val retrofit: Retrofit
) : MovieRepository {

    private val api = retrofit.create(MovieService::class.java)

    override suspend fun getMovies(): List<Movie> {
        return api.getMovies().items.map { it.mapToDomain() }
    }

    override suspend fun getMovieDetail(): MovieDetail {
        return api.getMovideDetail()
    }
}
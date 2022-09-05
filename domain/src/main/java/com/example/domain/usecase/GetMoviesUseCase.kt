package com.example.domain.usecase

import com.example.domain.model.Movie
import com.example.domain.model.Movie.Companion.veryGoodMovie
import com.example.domain.repository.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend fun execute(): Result<List<Movie>> {
        return try {
            val data = repository.getMovies()
            Result.Success(data)
        } catch (e: Throwable) {
            Result.Error(e.localizedMessage ?: e.toString())
        }
    }

}
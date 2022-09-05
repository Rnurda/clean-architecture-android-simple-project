package com.example.domain.usecase

import com.example.domain.model.Movie
import com.example.domain.model.MovieDetail
import com.example.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    suspend fun execute(): Result<MovieDetail> {
        return try {
            val data = repository.getMovieDetail()
            Result.Success(data)
        } catch (e: Throwable) {
            Result.Error(e.localizedMessage ?: e.toString())
        }
    }

}
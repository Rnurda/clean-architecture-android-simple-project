package com.example.data.api

import com.example.data.model.MoviesResponse
import com.example.domain.model.MovieDetail
import retrofit2.http.GET

interface MovieService {

    @GET("API/Top250Movies/k_uafu9rmg")
    suspend fun getMovies(): MoviesResponse

    suspend fun getMovideDetail(): MovieDetail
}
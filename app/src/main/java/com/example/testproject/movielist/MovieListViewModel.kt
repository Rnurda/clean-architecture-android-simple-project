package com.example.testproject.movielist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Movie
import com.example.domain.usecase.GetMoviesUseCase
import com.example.domain.usecase.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    val movies = MutableStateFlow(emptyList<Movie>())
    val isLoading = MutableStateFlow(false)
    val error = MutableSharedFlow<String>()

    init {
        getMovies()
    }

    private fun getMovies() = viewModelScope.launch {
        isLoading.emit(true)
        when (val result = getMoviesUseCase.execute()) {
            is Result.Success -> movies.emit(result.data)
            is Result.Error -> error.emit(result.message)
        }
        isLoading.emit(false)
    }


}
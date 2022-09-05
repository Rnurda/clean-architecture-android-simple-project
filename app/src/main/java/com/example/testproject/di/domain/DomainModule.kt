package com.example.testproject.di.domain

import com.example.domain.repository.MovieRepository
import com.example.domain.usecase.GetMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    fun provideUseCase(repository: MovieRepository) : GetMoviesUseCase {
        return GetMoviesUseCase(repository)
    }

}
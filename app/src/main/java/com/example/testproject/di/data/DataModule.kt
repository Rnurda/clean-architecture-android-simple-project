package com.example.testproject.di.data

import com.example.data.repository.MovieRepositoryImpl
import com.example.domain.repository.MovieRepository
import com.mocklets.pluto.PlutoInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRepository(retrofit: Retrofit): MovieRepository {
        return MovieRepositoryImpl(retrofit)
    }

    @Provides
    @Singleton
    fun provideRetrifit() : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://imdb-api.com/en/")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(PlutoInterceptor())
                    .addInterceptor { chain ->
                        val request: Request = chain.request().newBuilder()
                            .addHeader("Accept", "Application/JSON").build()
                        chain.proceed(request)
                    }
                    .build()
            )
            .build()
    }
}
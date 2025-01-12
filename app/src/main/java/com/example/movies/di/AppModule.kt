package com.example.movies.di

import com.example.movies.data.MovieApi
import com.example.movies.data.repository.RemoteDataRepositoryImpl
import com.example.movies.domain.repository.RemoteDataRepository
import com.example.movies.domain.use_case.GetMovieDataUseCase
import com.example.movies.domain.use_case.GetSearchResultUseCase
import com.example.movies.domain.use_case.UseCases
import com.example.movies.util.Constants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi
        .Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun provideMovieApi(moshi: Moshi): MovieApi {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: MovieApi): RemoteDataRepository {
        return RemoteDataRepositoryImpl(api)
    }
}
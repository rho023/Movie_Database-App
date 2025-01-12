package com.example.movies.data

import com.example.movies.data.dto.MovieDataDto
import com.example.movies.data.dto.SearchResultDto
import com.example.movies.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface MovieApi {

    @GET("/")
    suspend fun getMovieData(
        @Query("apikey") apikey: String = Constants.API_KEY,
        @QueryMap options: Map<String, String> = mapOf("plot" to "full", "type" to "movie"),
        @Query("t") title: String
    ): MovieDataDto

    @GET("/")
    suspend fun searchMovies(
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("type") type: String = "movie",
        @Query("s") search: String
    ): SearchResultDto
}
package com.example.movies.domain.repository

import com.example.movies.data.dto.MovieDataDto
import com.example.movies.data.dto.SearchResultDto

interface RemoteDataRepository {

    suspend fun getMovieData(title: String): MovieDataDto
    suspend fun getSearchResult(search: String): SearchResultDto
}
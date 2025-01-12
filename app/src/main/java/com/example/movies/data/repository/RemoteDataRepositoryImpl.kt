package com.example.movies.data.repository

import com.example.movies.data.MovieApi
import com.example.movies.data.dto.MovieDataDto
import com.example.movies.data.dto.SearchResultDto
import com.example.movies.domain.repository.RemoteDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataRepositoryImpl @Inject constructor(
    private val api: MovieApi
): RemoteDataRepository {
    override suspend fun getMovieData(title: String): MovieDataDto {
        return withContext(Dispatchers.Default) {
            api.getMovieData(title = title)
        }
    }

    override suspend fun getSearchResult(search: String): SearchResultDto {
        return withContext(Dispatchers.Default) {
            api.searchMovies(search = search)
        }
    }
}
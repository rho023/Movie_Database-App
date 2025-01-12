package com.example.movies.domain.use_case

import com.example.movies.data.dto.MovieDataDto
import com.example.movies.domain.repository.RemoteDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieDataUseCase @Inject constructor(
    private val repository: RemoteDataRepository
) {
    suspend operator fun invoke(title: String): Flow<MovieDataDto> = flow {
        emit(repository.getMovieData(title))
    }
}
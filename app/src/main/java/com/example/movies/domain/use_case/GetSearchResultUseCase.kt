package com.example.movies.domain.use_case

import com.example.movies.data.dto.SearchResultDto
import com.example.movies.domain.model.SearchResult
import com.example.movies.domain.repository.RemoteDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSearchResultUseCase @Inject constructor(
    private val repository: RemoteDataRepository
) {
    suspend operator fun invoke(search: String): Flow<SearchResultDto> = flow {
        emit(repository.getSearchResult(search))
    }
}
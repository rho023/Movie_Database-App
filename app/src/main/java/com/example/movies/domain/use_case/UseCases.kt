package com.example.movies.domain.use_case

import javax.inject.Inject

data class UseCases @Inject constructor(
    val getMovieDataUseCase: GetMovieDataUseCase,
    val getSearchResultUseCase: GetSearchResultUseCase
)

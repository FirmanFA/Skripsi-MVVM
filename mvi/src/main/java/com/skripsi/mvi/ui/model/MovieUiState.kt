package com.skripsi.mvi.ui.model

import com.skripsi.mvi.data.api.model.MovieResponse
import retrofit2.Response

sealed class MovieUiState {
    object Loading : MovieUiState()
    data class Success(val movie:Response<MovieResponse>): MovieUiState()
    data class Error(val exception: Throwable): MovieUiState()
}
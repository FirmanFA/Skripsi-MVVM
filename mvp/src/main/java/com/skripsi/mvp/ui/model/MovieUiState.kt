package com.skripsi.mvp.ui.model

import com.skripsi.mvp.data.api.model.MovieResponse
import retrofit2.Response

sealed class MovieUiState {
    data class Success(val movie:Response<MovieResponse>): MovieUiState()
    object Loading : MovieUiState()
    data class Error(val exception: Throwable): MovieUiState()
}
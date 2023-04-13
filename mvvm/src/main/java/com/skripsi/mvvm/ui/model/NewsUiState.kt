package com.skripsi.mvvm.ui.model

import com.skripsi.mvvm.data.api.model.GetNewsResponse
import com.skripsi.mvvm.data.api.model.MovieResponse
import retrofit2.Response

sealed class NewsUiState {

    data class Success(val movie: Response<GetNewsResponse>): NewsUiState()
    object Loading : NewsUiState()
    data class Error(val exception: Throwable): NewsUiState()

}
package com.skripsi.mvp.ui.model

import com.skripsi.mvp.data.api.model.GetNewsResponse
import com.skripsi.mvp.data.api.model.MovieResponse
import retrofit2.Response

sealed class NewsUiState {

    data class Success(val movie: Response<GetNewsResponse>): NewsUiState()
    object Loading : NewsUiState()
    data class Error(val exception: Throwable): NewsUiState()

}
package com.skripsi.mvi.ui.model

import com.skripsi.mvi.data.api.model.GetNewsResponse
import retrofit2.Response

sealed class NewsUiState {
    object Loading : NewsUiState()
    data class Success(val news: Response<GetNewsResponse>): NewsUiState()
    data class Error(val exception: Throwable): NewsUiState()

}
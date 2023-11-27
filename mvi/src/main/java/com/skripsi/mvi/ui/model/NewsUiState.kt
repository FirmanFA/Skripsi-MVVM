package com.skripsi.mvi.ui.model

import com.skripsi.mvi.data.api.model.GetNewsResponse
import retrofit2.Response

sealed class NewsUiState {

    data class Success(val newsData: Response<GetNewsResponse>): NewsUiState()
    object Loading : NewsUiState()
    data class Error(val errorMsg: String): NewsUiState()

}
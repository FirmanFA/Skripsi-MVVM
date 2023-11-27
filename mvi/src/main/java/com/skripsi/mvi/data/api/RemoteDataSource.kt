package com.skripsi.mvi.data.api

import com.skripsi.mvi.ui.model.NewsUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class RemoteDataSource(
    private val apiService: ApiService
) {

    fun latestNews(source: String) = flow {
        while (true){
            val latestNews = apiService.latestCnnNews(newsSource = source)
            emit(NewsUiState.Success(latestNews))
            delay(30000)
        }
    }


}
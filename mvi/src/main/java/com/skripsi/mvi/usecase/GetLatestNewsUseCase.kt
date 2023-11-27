package com.skripsi.mvi.usecase

import com.skripsi.mvi.domain.usecase.GetLatestNews
import com.skripsi.mvi.repository.MainRepository
import com.skripsi.mvi.ui.model.NewsUiState
import kotlinx.coroutines.flow.Flow

class GetLatestNewsUseCase(private val repository: MainRepository) : GetLatestNews() {

    override fun execute(params: String?): Flow<NewsUiState> =
        repository.getLatestNews(params ?: "cnn")

}
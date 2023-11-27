package com.skripsi.mvi.repository

import kotlinx.coroutines.flow.Flow
import com.skripsi.mvi.ui.model.NewsUiState

typealias NewsFlow = Flow<NewsUiState>
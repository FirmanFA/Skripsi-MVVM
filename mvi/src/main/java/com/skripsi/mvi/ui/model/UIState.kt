package com.skripsi.mvi.ui.model

import com.skripsi.mvi.ui.model.base.ISingleUiState
import com.skripsi.mvi.ui.model.base.IUiState

data class UIState(val newsUiState: NewsUiState, val movieUiState: MovieUiState):IUiState
data class SingleUiState(val message: String) : ISingleUiState
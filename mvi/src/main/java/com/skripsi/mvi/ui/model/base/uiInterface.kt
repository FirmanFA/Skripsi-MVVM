package com.skripsi.mvi.ui.model.base

interface IUiState
interface ISingleUiState

object EmptySingleState : ISingleUiState

sealed class LoadUiState {
    data class Loading(var isShow: Boolean) : LoadUiState()
    object ShowMainView : LoadUiState()
    data class Error(val msg: String) : LoadUiState()
}
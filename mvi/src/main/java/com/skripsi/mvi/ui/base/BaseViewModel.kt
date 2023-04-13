package com.skripsi.mvi.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skripsi.mvi.domain.Resource
import com.skripsi.mvi.ui.model.base.ISingleUiState
import com.skripsi.mvi.ui.model.base.IUiState
import com.skripsi.mvi.ui.model.base.LoadUiState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class BaseViewModel<UiState : IUiState, SingleUiState : ISingleUiState> : ViewModel() {

    private val _uiStateFlow = MutableStateFlow(initUiState())
    val uiStateFlow: StateFlow<UiState> = _uiStateFlow

    private val _sUiStateFlow: Channel<SingleUiState> = Channel()
    val sUiStateFlow: Flow<SingleUiState> = _sUiStateFlow.receiveAsFlow()

    private val _loadUiStateFlow: Channel<LoadUiState> = Channel()
    val loadUiStateFlow: Flow<LoadUiState> = _loadUiStateFlow.receiveAsFlow()

    protected abstract fun initUiState(): UiState

    protected fun sendUiState(copy: UiState.() -> UiState) {
        _uiStateFlow.update { _uiStateFlow.value.copy() }
    }

    protected fun sendSingleUiState(sUiState: SingleUiState) {
        viewModelScope.launch {
            _sUiStateFlow.send(sUiState)
        }
    }

    private fun sendLoadUiState(loadState: LoadUiState) {
        viewModelScope.launch {
            _loadUiStateFlow.send(loadState)
        }
    }

    protected fun <T : Any> requestDataWithFlow(
        showLoading: Boolean = true,
        request: suspend () -> Flow<Resource<T>>,
        successCallback: (T) -> Unit,
        failCallback: suspend (String) -> Unit = { errMsg ->
            sendLoadUiState(LoadUiState.Error(errMsg))
        },
    ) {
        viewModelScope.launch {
            if (showLoading) {
                sendLoadUiState(LoadUiState.Loading(true))
            }
            val resource: Flow<Resource<T>>
            try {
                resource = request()

                resource.collect { resourceState ->
                    when (resourceState) {
                        is Resource.Failure -> resourceState.e.localizedMessage?.let {
                            error(it)
                        }
                        is Resource.Pending -> {

                        }
                        is Resource.Success -> {
                            sendLoadUiState(LoadUiState.ShowMainView)
                            resourceState.data?.let { successCallback(it) }
                        }
                    }
                }

            } catch (e: Exception) {
                e.message?.let { failCallback(it) }
            } finally {
                if (showLoading) {
                    sendLoadUiState(LoadUiState.Loading(false))
                }
            }
        }
    }

}
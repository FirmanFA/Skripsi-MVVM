package com.skripsi.mvi.domain

import com.skripsi.mvi.ui.model.NewsUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlin.coroutines.CoroutineContext

abstract class UseCase<in Params, out Type>(private val context: CoroutineContext = Dispatchers.IO) {

    abstract fun execute(params: Params?): Flow<NewsUiState>

    operator fun invoke(params: Params?) =
        execute(params)
            .onStart { emit(NewsUiState.Loading) }
            .catch { emit(NewsUiState.Error(it.localizedMessage ?: "Error Occured")) }
            .flowOn(context)

}
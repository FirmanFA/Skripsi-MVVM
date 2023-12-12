package com.skripsi.mvi.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skripsi.mvi.domain.usecase.GetLatestNews
import com.skripsi.mvi.ui.model.NewsIntents
import com.skripsi.mvi.ui.model.NewsUiState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(
    private val getLatestNews: GetLatestNews
) : ViewModel() {

    private val _bbcNewsState = MutableStateFlow<NewsUiState>(NewsUiState.Loading)
    val bbcNewsState : StateFlow<NewsUiState> get() = _bbcNewsState

    private val _espnNewsState = MutableStateFlow<NewsUiState>(NewsUiState.Loading)
    val espnNewsState : StateFlow<NewsUiState> get() = _espnNewsState

    val newsChannel = Channel<NewsIntents>(Channel.UNLIMITED)

    private val _cnnNewsState = MutableStateFlow<NewsUiState>(NewsUiState.Loading)
    val cnnNewsState : StateFlow<NewsUiState> get() = _cnnNewsState
    init {
        handleIntents()
    }
    private fun handleIntents() {
        viewModelScope.launch {
            newsChannel.consumeAsFlow().collect{
                when(it){
                    NewsIntents.LatestCnnNews -> getCnnNews()
                    NewsIntents.LatestBBCNews -> getBBCNews()
                    NewsIntents.LatestESPNNews -> getEspnNews()
                }
            }
        }
    }
    private suspend fun getCnnNews() {
        viewModelScope.launch {
            getLatestNews.execute("cnn").collect {
                _cnnNewsState.value = it
            }
        }
    }

    private suspend fun getBBCNews() {

        Log.d("get news","get bbc news")

        viewModelScope.launch {
            getLatestNews.execute("bbc-news").collect {
                _bbcNewsState.value = it
            }
        }
    }

    private suspend fun getEspnNews() {

        Log.d("get news","get espn news")

        viewModelScope.launch {
            getLatestNews.execute("espn").collect {
                _espnNewsState.value = it
            }
        }
    }

}
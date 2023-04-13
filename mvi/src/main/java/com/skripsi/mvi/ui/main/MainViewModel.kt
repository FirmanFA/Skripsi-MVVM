package com.skripsi.mvi.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skripsi.mvi.data.api.model.GetNewsResponse
import com.skripsi.mvi.data.api.model.MovieResponse
import com.skripsi.mvi.domain.Resource
import com.skripsi.mvi.domain.usecase.GetDiscoveryMovies
import com.skripsi.mvi.domain.usecase.GetLatestNews
import com.skripsi.mvi.ui.base.BaseViewModel
import com.skripsi.mvi.ui.model.MovieUiState
import com.skripsi.mvi.ui.model.NewsUiState
import com.skripsi.mvi.ui.model.SingleUiState
import com.skripsi.mvi.ui.model.UIState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(
    private val getDiscoveryMovies: GetDiscoveryMovies,
    private val getLatestNews: GetLatestNews
) : BaseViewModel<UIState, SingleUiState>() {

    override fun initUiState(): UIState = UIState(NewsUiState.Loading, MovieUiState.Loading)


    fun loadLatestNews(){
        requestDataWithFlow(
            showLoading = true,
            request = {
                getLatestNews(null)
            },
            successCallback = {
                sendUiState {
                    copy(newsUiState = NewsUiState.Success(it))
                }
            },
            failCallback = {
                showToast(it)
            }
        )
    }

    fun showToast(msg: String){
        sendSingleUiState(SingleUiState(msg))
    }

}
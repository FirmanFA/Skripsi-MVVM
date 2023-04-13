package com.skripsi.mvvm.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skripsi.mvvm.data.api.model.GetNewsResponse
import com.skripsi.mvvm.data.api.model.MovieResponse
import com.skripsi.mvvm.domain.Resource
import com.skripsi.mvvm.domain.usecase.GetDiscoveryMovies
import com.skripsi.mvvm.domain.usecase.GetLatestNews
import com.skripsi.mvvm.ui.model.MovieUiState
import com.skripsi.mvvm.ui.model.NewsUiState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(
    private val getDiscoveryMovies: GetDiscoveryMovies,
    private val getLatestNews: GetLatestNews
) : ViewModel() {

    private val _discoverMovie =
        MutableStateFlow<Resource<Response<MovieResponse>>>(Resource.Pending)
    val discoverMovie get() = _discoverMovie

    fun getDiscoveryMovie() {
        getDiscoveryMovies(null)
            .onEach {
                _discoverMovie.value = it
            }.catch {
                it.printStackTrace()
            }.launchIn(viewModelScope)
    }

    private val _news =
        MutableStateFlow<Resource<Response<GetNewsResponse>>>(Resource.Pending)
    val news get() = _news

    fun getNews() {
        getLatestNews(null)
            .onEach {
                _news.value = it
            }.catch {
                it.printStackTrace()
            }.launchIn(viewModelScope)
    }

}
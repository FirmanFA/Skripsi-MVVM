package com.skripsi.mvvm.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skripsi.mvvm.data.api.model.GetNewsResponse
import com.skripsi.mvvm.domain.Resource
import com.skripsi.mvvm.domain.usecase.GetLatestNews
import kotlinx.coroutines.flow.*
import retrofit2.Response

class MainViewModel(
    private val getLatestNews: GetLatestNews
) : ViewModel() {

    private val _cnnNews =
        MutableStateFlow<Resource<Response<GetNewsResponse>>>(Resource.Pending)
    val cnnNews get() = _cnnNews

    private val _bbcNews =
        MutableStateFlow<Resource<Response<GetNewsResponse>>>(Resource.Pending)
    val bbcNews get() = _bbcNews

    private val _espnNews =
        MutableStateFlow<Resource<Response<GetNewsResponse>>>(Resource.Pending)
    val espnNews get() = _espnNews

    fun getCnnNews() {
        getLatestNews("cnn")
            .onEach {
                _cnnNews.value = it
            }.catch {
                it.printStackTrace()
            }.launchIn(viewModelScope)
    }

    fun getBccNews() {
        getLatestNews("bbc-news")
            .onEach {
                _bbcNews.value = it
            }.catch {
                it.printStackTrace()
            }.launchIn(viewModelScope)
    }

    fun getEspnNews() {
        getLatestNews("espn")
            .onEach {
                _espnNews.value = it
            }.catch {
                it.printStackTrace()
            }.launchIn(viewModelScope)
    }

}
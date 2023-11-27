package com.skripsi.mvp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skripsi.mvp.data.api.model.GetNewsResponse
import com.skripsi.mvp.domain.Resource
import com.skripsi.mvp.domain.usecase.GetLatestNews
import kotlinx.coroutines.flow.*
import retrofit2.Response

class MainPresenter(private val getLatestNews: GetLatestNews):ViewModel(), MainContract.Presenter {

    override fun fetchCnnNews(): StateFlow<Resource<Response<GetNewsResponse>>> {

        val news =
            MutableStateFlow<Resource<Response<GetNewsResponse>>>(Resource.Pending)

        getLatestNews("cnn")
            .onEach {
                news.value = it
            }.catch {
                it.printStackTrace()
            }.launchIn(viewModelScope)

        return news

    }

    override fun fetchBBCNews(): StateFlow<Resource<Response<GetNewsResponse>>> {

        val news =
            MutableStateFlow<Resource<Response<GetNewsResponse>>>(Resource.Pending)

        getLatestNews("bbc-news")
            .onEach {
                news.value = it
            }.catch {
                it.printStackTrace()
            }.launchIn(viewModelScope)

        return news

    }

    override fun fetchESPNNews(): StateFlow<Resource<Response<GetNewsResponse>>> {

        val news =
            MutableStateFlow<Resource<Response<GetNewsResponse>>>(Resource.Pending)

        getLatestNews("espn")
            .onEach {
                news.value = it
            }.catch {
                it.printStackTrace()
            }.launchIn(viewModelScope)

        return news

    }
}
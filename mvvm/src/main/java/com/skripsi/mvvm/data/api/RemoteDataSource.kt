package com.skripsi.mvvm.data.api

import com.skripsi.mvvm.data.api.model.GetNewsResponse
import com.skripsi.mvvm.domain.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.mapLatest
import retrofit2.Response

class RemoteDataSource(
    private val apiService: ApiService
) {

    val discoverMovies = flow {
        while (true){
            val discoverMovies = apiService.getDiscoverMovie()
            emit(Resource.Success(discoverMovies))
            delay(30000)
        }
    }

    fun latestNews(source: String) = flow {
        while (true){
            val latestNews = apiService.latestCnnNews(newsSource = source)
            emit(Resource.Success(latestNews))
            delay(30000)
        }
    }


}
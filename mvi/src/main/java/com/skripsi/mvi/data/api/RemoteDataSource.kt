package com.skripsi.mvi.data.api

import com.skripsi.mvi.data.api.model.GetNewsResponse
import com.skripsi.mvi.domain.Resource
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

    val latestNews = flow {
        while (true){
            val latestNews = apiService.latestCnnNews()
            emit(Resource.Success(latestNews))
            delay(30000)
        }
    }


}
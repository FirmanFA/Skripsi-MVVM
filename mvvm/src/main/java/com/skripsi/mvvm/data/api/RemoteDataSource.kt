package com.skripsi.mvvm.data.api

import com.skripsi.mvvm.domain.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class RemoteDataSource(
    private val apiService: ApiService
) {

    fun latestNews(source: String) = flow {
        while (true){
            val latestNews = apiService.latestCnnNews(newsSource = source)
            emit(Resource.Success(latestNews))
            delay(30000)
        }
    }


}
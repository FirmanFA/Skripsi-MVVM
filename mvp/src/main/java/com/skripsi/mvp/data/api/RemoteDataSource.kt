package com.skripsi.mvp.data.api

import com.skripsi.mvp.domain.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class RemoteDataSource(
    private val apiService: ApiService
) {

    fun latestNews(source: String) = flow {
        while (true){
            val latestNews = apiService.latestNews(newsSource = source)
            emit(Resource.Success(latestNews))
            delay(30000)
        }
    }

}
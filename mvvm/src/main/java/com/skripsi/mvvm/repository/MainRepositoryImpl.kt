package com.skripsi.mvvm.repository

import com.skripsi.mvvm.data.api.RemoteDataSource

class MainRepositoryImpl(private val remoteDataSource: RemoteDataSource) : MainRepository {
    override fun getLatestNews(source: String): NewsFlow = remoteDataSource.latestNews(source)

}
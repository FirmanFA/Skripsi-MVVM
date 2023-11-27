package com.skripsi.mvi.repository

import com.skripsi.mvi.data.api.RemoteDataSource

class MainRepositoryImpl(private val remoteDataSource: RemoteDataSource) : MainRepository {

    override fun getLatestNews(source: String): NewsFlow = remoteDataSource.latestNews(source)

}
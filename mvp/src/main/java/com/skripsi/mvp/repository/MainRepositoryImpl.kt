package com.skripsi.mvp.repository

import com.skripsi.mvp.data.api.RemoteDataSource


class MainRepositoryImpl(private val remoteDataSource: RemoteDataSource) : MainRepository {

    override fun getLatestNews(source: String): NewsFlow = remoteDataSource.latestNews(source)

}
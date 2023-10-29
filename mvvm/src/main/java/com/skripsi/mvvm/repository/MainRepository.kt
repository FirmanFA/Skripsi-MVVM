package com.skripsi.mvvm.repository

interface MainRepository {
    fun getMain(): StringFlow
    fun postMain(): StringFlow
    fun getDiscoveryMovies(): MovieFlow
    fun getLatestNews(source: String): NewsFlow
}
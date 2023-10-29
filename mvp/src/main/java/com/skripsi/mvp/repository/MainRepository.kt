package com.skripsi.mvp.repository

interface MainRepository {
    fun getMain(): StringFlow
    fun postMain(): StringFlow
    fun getDiscoveryMovies(): MovieFlow
    fun getLatestNews(): NewsFlow
}
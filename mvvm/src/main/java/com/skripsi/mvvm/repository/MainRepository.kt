package com.skripsi.mvvm.repository

interface MainRepository {
    fun getLatestNews(source: String): NewsFlow
}
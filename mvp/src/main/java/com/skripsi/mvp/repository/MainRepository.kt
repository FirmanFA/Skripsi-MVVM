package com.skripsi.mvp.repository


interface MainRepository {
    fun getLatestNews(source: String): NewsFlow
}
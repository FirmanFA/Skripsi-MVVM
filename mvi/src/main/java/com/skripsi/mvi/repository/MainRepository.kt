package com.skripsi.mvi.repository

interface MainRepository {
    fun getLatestNews(source: String): NewsFlow
}
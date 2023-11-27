package com.skripsi.mvp.di

import com.skripsi.mvp.data.api.ApiService
import com.skripsi.mvp.data.api.RemoteDataSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL_MOVIE = "https://newsapi.org/v2/"
val api = module {

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL_MOVIE)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single {
        get<Retrofit>().create(ApiService::class.java)
    }

    singleOf(::RemoteDataSource)

}
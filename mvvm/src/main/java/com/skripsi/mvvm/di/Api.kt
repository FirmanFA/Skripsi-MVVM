package com.skripsi.mvvm.di

import com.skripsi.mvvm.data.api.ApiService
import com.skripsi.mvvm.data.api.RemoteDataSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.themoviedb.org/3/"
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
//            .addInterceptor {
//                val request = it.request()
//                val queryBuild =  request.url
//                    .newBuilder()
//                    .addQueryParameter("api_key","5374e8eba1107b24236cc30d17d5aa11").build()
//                it.proceed(request.newBuilder().url(queryBuild).build())
//            }
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
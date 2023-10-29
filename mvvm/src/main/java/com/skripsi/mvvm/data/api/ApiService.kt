package com.skripsi.mvvm.data.api

import com.skripsi.mvvm.data.api.model.DetailMovieResponse
import com.skripsi.mvvm.data.api.model.GetNewsResponse
import com.skripsi.mvvm.data.api.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/now_playing")
    suspend fun getAiringMovie(): Response<MovieResponse>

    @GET("discover/movie")
    suspend fun getDiscoverMovie(): Response<MovieResponse>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovie(): Response<MovieResponse>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovie(): Response<MovieResponse>

    @GET("movie/{movieId}")
    suspend fun getDetailMovie(@Path("movieId") movieId: Int): Response<DetailMovieResponse>

    @GET("movie/{movieId}/similar")
    suspend fun getSimilarMovie(@Path("movieId") movieId: Int): Response<MovieResponse>

    @GET("everything")
    suspend fun latestCnnNews(
        @Query("sources") newsSource: String,
        @Query("pageSize") pageSize: String? = "10",
        @Query("apiKey") key: String? = "eaf426a2899140b582bc50f9a66ec49a",
    ): Response<GetNewsResponse>

}
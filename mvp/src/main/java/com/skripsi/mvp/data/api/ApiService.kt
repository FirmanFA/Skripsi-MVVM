package com.skripsi.mvp.data.api

import com.skripsi.mvp.data.api.model.DetailMovieResponse
import com.skripsi.mvp.data.api.model.GetNewsResponse
import com.skripsi.mvp.data.api.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

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

    @GET("everything?sources=cnn&pageSize=1&apiKey=eaf426a2899140b582bc50f9a66ec49a")
    suspend fun latestCnnNews(): Response<GetNewsResponse>

}
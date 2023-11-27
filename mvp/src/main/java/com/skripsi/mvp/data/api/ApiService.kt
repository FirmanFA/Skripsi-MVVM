package com.skripsi.mvp.data.api

import com.skripsi.mvp.data.api.model.GetNewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("everything")
    suspend fun latestCnnNews(
        @Query("sources") newsSource: String,
        @Query("pageSize") pageSize: String? = "10",
        @Query("apiKey") key: String? = "eaf426a2899140b582bc50f9a66ec49a",
    ): Response<GetNewsResponse>

}
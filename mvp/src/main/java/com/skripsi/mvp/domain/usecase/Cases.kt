package com.skripsi.mvp.domain.usecase

import androidx.lifecycle.viewmodel.CreationExtras
import com.skripsi.mvp.data.api.model.GetNewsResponse
import com.skripsi.mvp.data.api.model.MovieResponse
import com.skripsi.mvp.domain.UseCase
import retrofit2.Response

typealias GetMain = UseCase<String, String>

typealias PostMain = UseCase<CreationExtras.Empty, String>

typealias GetDiscoveryMovies = UseCase<String, Response<MovieResponse>>

typealias GetLatestNews = UseCase<String, Response<GetNewsResponse>>
package com.skripsi.mvvm.domain.usecase

import androidx.lifecycle.viewmodel.CreationExtras
import com.skripsi.mvvm.data.api.model.GetNewsResponse
import com.skripsi.mvvm.data.api.model.MovieResponse
import com.skripsi.mvvm.domain.UseCase
import retrofit2.Response

typealias GetMain = UseCase<String, String>

typealias PostMain = UseCase<CreationExtras.Empty, String>

typealias GetDiscoveryMovies = UseCase<String, Response<MovieResponse>>

typealias GetLatestNews = UseCase<String, Response<GetNewsResponse>>
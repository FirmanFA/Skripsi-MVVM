package com.skripsi.mvi.domain.usecase

import androidx.lifecycle.viewmodel.CreationExtras
import com.skripsi.mvi.data.api.model.GetNewsResponse
import com.skripsi.mvi.data.api.model.MovieResponse
import com.skripsi.mvi.domain.UseCase
import retrofit2.Response

typealias GetMain = UseCase<String, String>

typealias PostMain = UseCase<CreationExtras.Empty, String>

typealias GetDiscoveryMovies = UseCase<String, Response<MovieResponse>>

typealias GetLatestNews = UseCase<String, Response<GetNewsResponse>>
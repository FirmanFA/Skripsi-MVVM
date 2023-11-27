package com.skripsi.mvi.domain.usecase

import com.skripsi.mvi.data.api.model.GetNewsResponse
import com.skripsi.mvi.domain.UseCase
import retrofit2.Response


typealias GetLatestNews = UseCase<String, Response<GetNewsResponse>>
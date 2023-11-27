package com.skripsi.mvvm.domain.usecase

import com.skripsi.mvvm.data.api.model.GetNewsResponse
import com.skripsi.mvvm.domain.UseCase
import retrofit2.Response

typealias GetLatestNews = UseCase<String, Response<GetNewsResponse>>
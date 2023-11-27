package com.skripsi.mvp.domain.usecase

import com.skripsi.mvp.data.api.model.GetNewsResponse
import com.skripsi.mvp.domain.UseCase
import retrofit2.Response

typealias GetLatestNews = UseCase<String, Response<GetNewsResponse>>
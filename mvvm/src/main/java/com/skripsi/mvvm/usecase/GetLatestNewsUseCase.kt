package com.skripsi.mvvm.usecase

import com.skripsi.mvvm.data.api.model.GetNewsResponse
import com.skripsi.mvvm.domain.Resource
import com.skripsi.mvvm.domain.usecase.GetLatestNews
import com.skripsi.mvvm.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class GetLatestNewsUseCase(private val repository: MainRepository) : GetLatestNews() {

    override fun execute(params: String?): Flow<Resource<Response<GetNewsResponse>>> =
        repository.getLatestNews(params ?: "cnn")

}
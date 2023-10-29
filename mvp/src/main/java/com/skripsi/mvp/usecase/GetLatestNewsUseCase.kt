package com.skripsi.mvp.usecase

import com.skripsi.mvp.data.api.model.GetNewsResponse
import com.skripsi.mvp.domain.Resource
import com.skripsi.mvp.domain.usecase.GetLatestNews
import com.skripsi.mvp.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class GetLatestNewsUseCase(private val repository: MainRepository) : GetLatestNews() {

    override fun execute(params: String?): Flow<Resource<Response<GetNewsResponse>>> =
        repository.getLatestNews()

}
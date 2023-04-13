package com.skripsi.mvi.usecase

import com.skripsi.mvi.data.api.model.GetNewsResponse
import com.skripsi.mvi.domain.Resource
import com.skripsi.mvi.domain.usecase.GetLatestNews
import com.skripsi.mvi.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class GetLatestNewsUseCase(private val repository: MainRepository) : GetLatestNews() {

    override fun execute(params: String?): Flow<Resource<Response<GetNewsResponse>>> =
        repository.getLatestNews()

}
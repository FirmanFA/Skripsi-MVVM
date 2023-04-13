package com.skripsi.mvvm.domain.usecase

import com.skripsi.mvvm.data.api.model.MovieResponse
import com.skripsi.mvvm.domain.Resource
import com.skripsi.mvvm.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class GetDiscoveryMoviesUseCase(private val repository: MainRepository) : GetDiscoveryMovies() {

    override fun execute(params: String?): Flow<Resource<Response<MovieResponse>>> =
        repository.getDiscoveryMovies()

}
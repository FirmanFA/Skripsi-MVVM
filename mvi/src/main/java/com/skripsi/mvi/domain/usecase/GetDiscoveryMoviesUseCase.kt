package com.skripsi.mvi.domain.usecase

import com.skripsi.mvi.data.api.model.MovieResponse
import com.skripsi.mvi.domain.Resource
import com.skripsi.mvi.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class GetDiscoveryMoviesUseCase(private val repository: MainRepository) : GetDiscoveryMovies() {

    override fun execute(params: String?): Flow<Resource<Response<MovieResponse>>> =
        repository.getDiscoveryMovies()

}
package com.skripsi.mvp.domain.usecase

import com.skripsi.mvp.data.api.model.MovieResponse
import com.skripsi.mvp.domain.Resource
import com.skripsi.mvp.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class GetDiscoveryMoviesUseCase(private val repository: MainRepository) : GetDiscoveryMovies() {

    override fun execute(params: String?): Flow<Resource<Response<MovieResponse>>> =
        repository.getDiscoveryMovies()

}
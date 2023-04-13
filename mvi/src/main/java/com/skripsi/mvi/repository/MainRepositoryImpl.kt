package com.skripsi.mvi.repository

import com.skripsi.mvi.data.api.RemoteDataSource
import kotlinx.coroutines.flow.flow
import com.skripsi.mvi.domain.Resource
import kotlinx.coroutines.flow.map
import retrofit2.Response

class MainRepositoryImpl(private val remoteDataSource: RemoteDataSource) : MainRepository {

    override fun getMain() = flow {
        emit(Resource.Success("result"))
    }

    override fun postMain() = flow {
        emit(Resource.Failure(RuntimeException()))
    }

    override fun getDiscoveryMovies(): MovieFlow =
        remoteDataSource
            .discoverMovies
            .map {
                Resource.Success(Response.success(
                    it.data?.body()?.apply {
                        //show only movie with video attached
                        results.filter { movie ->
                            movie.video
                        }
                    }
                ))
            }

    override fun getLatestNews(): NewsFlow = remoteDataSource.latestNews

}
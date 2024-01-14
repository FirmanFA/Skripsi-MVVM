package com.skripsi.mvp.repository

import com.skripsi.mvp.data.api.ApiService
import com.skripsi.mvp.data.api.RemoteDataSource
import com.skripsi.mvp.data.api.model.GetNewsResponse
import com.skripsi.mvp.domain.Resource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import retrofit2.Response
import java.util.concurrent.Flow

class MainRepositoryImplTest {

    private lateinit var mainRepository: MainRepository
    private lateinit var remoteDataSource: RemoteDataSource
    private lateinit var apiService: ApiService

    @Before
    fun setUp() {

        apiService = mockk()

        remoteDataSource = RemoteDataSource(apiService)

        mainRepository = MainRepositoryImpl(remoteDataSource)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getLatestNews(): Unit = runTest {

        val responseLatestNews = mockk<Resource<Response<GetNewsResponse>>>()

        every {
            runBlocking {
                var latestNewsData: Resource<Response<GetNewsResponse>> = Resource.Pending
                mainRepository.getLatestNews("cnn").take(1).collectLatest {
                    latestNewsData = it
                }
                latestNewsData
            }
        } returns responseLatestNews

    }
}
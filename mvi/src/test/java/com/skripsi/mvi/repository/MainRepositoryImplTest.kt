package com.skripsi.mvi.repository

import com.skripsi.mvi.data.api.ApiService
import com.skripsi.mvi.data.api.RemoteDataSource
import com.skripsi.mvi.ui.model.NewsUiState
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

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

        val responseLatestNews = mockk<NewsUiState>()

        every {
            runBlocking {
                var latestNewsData: NewsUiState = NewsUiState.Loading
                mainRepository.getLatestNews("cnn").take(1).collectLatest {
                    latestNewsData = it
                }
                latestNewsData
            }
        } returns responseLatestNews

    }
}
package com.skripsi.mvvm.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.skripsi.mvvm.data.api.model.GetNewsResponse
import com.skripsi.mvvm.domain.Resource
import com.skripsi.mvvm.domain.usecase.GetLatestNews
import com.skripsi.mvvm.repository.MainRepository
import com.skripsi.mvvm.rule.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito
import org.mockito.kotlin.given
import org.mockito.kotlin.mock
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    private lateinit var getLatestNews: GetLatestNews
    private lateinit var viewModel: MainViewModel

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()


    @Before
    fun setUp() {
        getLatestNews = mock()
        viewModel = MainViewModel(getLatestNews)
    }


    @Test
    fun getCnnNews() = runTest {

        val cnnNewsResponse = mock<Flow<Resource<Response<GetNewsResponse>>>>()

        given(getLatestNews.execute("cnn")).willReturn(cnnNewsResponse)

        viewModel.getCnnNews()

        advanceUntilIdle()

        kotlin.test.assertNotNull(viewModel.cnnNews.value)

    }

    @Test
    fun getBbcNews() = runTest {

        val bbcNewsResponse = mock<Flow<Resource<Response<GetNewsResponse>>>>()

        given(getLatestNews.execute("bbc-news")).willReturn(bbcNewsResponse)

        viewModel.getCnnNews()

        advanceUntilIdle()

        kotlin.test.assertNotNull(viewModel.bbcNews.value)

    }

    @Test
    fun getEspnNews() = runTest {

        val espnNewsResponse = mock<Flow<Resource<Response<GetNewsResponse>>>>()

        given(getLatestNews.execute("espn")).willReturn(espnNewsResponse)

        viewModel.getCnnNews()

        advanceUntilIdle()

        kotlin.test.assertNotNull(viewModel.espnNews.value)

    }
}
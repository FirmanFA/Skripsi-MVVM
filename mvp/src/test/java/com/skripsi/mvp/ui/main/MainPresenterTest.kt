package com.skripsi.mvp.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.skripsi.mvp.data.api.model.GetNewsResponse
import com.skripsi.mvp.domain.Resource
import com.skripsi.mvp.domain.usecase.GetLatestNews
import com.skripsi.mvp.rule.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.kotlin.given
import org.mockito.kotlin.mock
import retrofit2.Response

class MainPresenterTest {

    private lateinit var getLatestNews: GetLatestNews
    private lateinit var presenter: MainPresenter

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()


    @Before
    fun setUp() {
        getLatestNews = mock()
        presenter = MainPresenter(getLatestNews)
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getCnnNews() = runTest {

        val cnnNewsResponse = mock<Flow<Resource<Response<GetNewsResponse>>>>()

        given(getLatestNews.execute("cnn")).willReturn(cnnNewsResponse)

        val data = presenter.fetchCnnNews()

        advanceUntilIdle()

        kotlin.test.assertNotNull(data.value)

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getBbcNews() = runTest {

        val bbcNewsResponse = mock<Flow<Resource<Response<GetNewsResponse>>>>()

        given(getLatestNews.execute("bbc-news")).willReturn(bbcNewsResponse)

        val data = presenter.fetchBBCNews()

        advanceUntilIdle()

        kotlin.test.assertNotNull(data.value)

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getEspnNews() = runTest {

        val espnNewsResponse = mock<Flow<Resource<Response<GetNewsResponse>>>>()

        given(getLatestNews.execute("espn")).willReturn(espnNewsResponse)

        val data = presenter.fetchESPNNews()

        advanceUntilIdle()

        kotlin.test.assertNotNull(data.value)

    }
}
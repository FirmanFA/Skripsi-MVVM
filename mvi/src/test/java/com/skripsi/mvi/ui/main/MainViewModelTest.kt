package com.skripsi.mvi.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.skripsi.mvi.domain.usecase.GetLatestNews
import com.skripsi.mvi.ui.model.NewsIntents
import com.skripsi.mvi.ui.model.NewsUiState
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
    fun getBbcNewsState() = runTest {

        val bbcNewsResponse = mock<Flow<NewsUiState>>()

        given(getLatestNews.execute("bbc-news")).willReturn(bbcNewsResponse)

        viewModel.newsChannel.send(NewsIntents.LatestBBCNews)

        advanceUntilIdle()

        kotlin.test.assertNotNull(viewModel.bbcNewsState.value)

    }

    @Test
    fun getEspnNewsState() = runTest {
        val espnNewsResponse = mock<Flow<NewsUiState>>()

        given(getLatestNews.execute("espn")).willReturn(espnNewsResponse)

        viewModel.newsChannel.send(NewsIntents.LatestESPNNews)

        advanceUntilIdle()

        kotlin.test.assertNotNull(viewModel.espnNewsState.value)
    }

    @Test
    fun getCnnNewsState() = runTest {

        val cnnNewsResponse = mock<Flow<NewsUiState>>()

        given(getLatestNews.execute("cnn")).willReturn(cnnNewsResponse)

        viewModel.newsChannel.send(NewsIntents.LatestCnnNews)

        advanceUntilIdle()

        kotlin.test.assertNotNull(viewModel.cnnNewsState.value)

    }
}
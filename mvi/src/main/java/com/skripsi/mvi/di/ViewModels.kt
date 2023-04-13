package com.skripsi.mvi.di

import com.skripsi.mvi.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModels = module {
    viewModel {
        MainViewModel(
            get(named("GetDiscoveryMovies")),
            get(named("GetLatestNews"))
        )
    }
}
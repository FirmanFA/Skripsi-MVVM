package com.skripsi.mvp.di

import com.skripsi.mvp.ui.main.MainPresenter
import com.skripsi.mvp.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModels = module {
    viewModel {
        MainViewModel(
            get(named("GetDiscoveryMovies")),
            get(named("GetLatestNews"))
        )

        MainPresenter(
            get(named("GetLatestNews"))
        )
    }

}
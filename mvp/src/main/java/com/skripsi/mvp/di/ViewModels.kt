package com.skripsi.mvp.di

import com.skripsi.mvp.ui.main.MainPresenter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModels = module {
    viewModel {
        MainPresenter(
            get(named("GetLatestNews"))
        )
    }

}
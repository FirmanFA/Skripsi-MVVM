package com.skripsi.mvi.di

import com.skripsi.mvi.domain.usecase.GetLatestNews
import com.skripsi.mvi.usecase.GetLatestNewsUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCases = module {

    single<GetLatestNews>(named("GetLatestNews")) { GetLatestNewsUseCase(get()) }
}
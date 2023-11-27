package com.skripsi.mvvm.di

import com.skripsi.mvvm.domain.usecase.*
import com.skripsi.mvvm.usecase.GetLatestNewsUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCases = module {
    single<GetLatestNews>(named("GetLatestNews")) { GetLatestNewsUseCase(get()) }
}
package com.skripsi.mvp.di

import com.skripsi.mvp.domain.usecase.*
import com.skripsi.mvp.usecase.GetLatestNewsUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCases = module {


    single<GetLatestNews>(named("GetLatestNews")) { GetLatestNewsUseCase(get()) }
}
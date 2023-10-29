package com.skripsi.mvp.di

import com.skripsi.mvp.domain.usecase.*
import com.skripsi.mvp.usecase.GetLatestNewsUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCases = module {

    single<GetMain>(named("GetMain")) { GetMainUseCase(get()) }

    single<PostMain>(named("PostMain")) { PostMainUseCase(get()) }

    single<GetDiscoveryMovies>(named("GetDiscoveryMovies")) { GetDiscoveryMoviesUseCase(get()) }

    single<GetLatestNews>(named("GetLatestNews")) { GetLatestNewsUseCase(get()) }
}
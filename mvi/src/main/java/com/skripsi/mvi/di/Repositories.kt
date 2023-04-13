package com.skripsi.mvi.di

import org.koin.dsl.module
import com.skripsi.mvi.repository.MainRepository
import com.skripsi.mvi.repository.MainRepositoryImpl

val repositories = module {
    single<MainRepository> { MainRepositoryImpl(get()) }
}
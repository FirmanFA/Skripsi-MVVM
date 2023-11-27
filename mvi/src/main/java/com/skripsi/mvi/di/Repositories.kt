package com.skripsi.mvi.di

import com.skripsi.mvi.repository.MainRepository
import com.skripsi.mvi.repository.MainRepositoryImpl
import org.koin.dsl.module

val repositories = module {
    single<MainRepository> { MainRepositoryImpl(get()) }
}
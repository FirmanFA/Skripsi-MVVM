package com.skripsi.mvp.di

import org.koin.dsl.module
import com.skripsi.mvp.repository.MainRepository
import com.skripsi.mvp.repository.MainRepositoryImpl

val repositories = module {
    single<MainRepository> { MainRepositoryImpl(get()) }
}
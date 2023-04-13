package com.skripsi.mvvm.di

import org.koin.dsl.module
import com.skripsi.mvvm.repository.MainRepository
import com.skripsi.mvvm.repository.MainRepositoryImpl

val repositories = module {
    single<MainRepository> { MainRepositoryImpl(get()) }
}
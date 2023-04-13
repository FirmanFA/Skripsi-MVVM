package com.skripsi.mvvm

import android.app.Application
import com.skripsi.mvvm.di.api
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import com.skripsi.mvvm.di.repositories
import com.skripsi.mvvm.di.useCases
import com.skripsi.mvvm.di.viewModels
import org.koin.android.ext.koin.androidLogger

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidLogger()

            androidContext(this@App)

            modules(
                useCases,
                api,
                viewModels,
                repositories,
            )
        }

    }
}
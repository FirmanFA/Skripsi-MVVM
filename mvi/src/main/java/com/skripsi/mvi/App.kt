package com.skripsi.mvi

import android.app.Application
import com.skripsi.mvi.di.api
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import com.skripsi.mvi.di.repositories
import com.skripsi.mvi.di.useCases
import com.skripsi.mvi.di.viewModels
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
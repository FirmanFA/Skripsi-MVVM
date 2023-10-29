package com.skripsi.mvp

import android.app.Application
import com.skripsi.mvp.di.api
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import com.skripsi.mvp.di.repositories
import com.skripsi.mvp.di.useCases
import com.skripsi.mvp.di.viewModels
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
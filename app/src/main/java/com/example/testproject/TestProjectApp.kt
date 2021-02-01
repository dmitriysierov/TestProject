package com.example.testproject

import android.app.Application
import com.example.testproject.di.AppModule
import com.example.testproject.di.NetworkModule
import com.example.testproject.di.RepositoryModule
import com.example.testproject.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class TestProjectApp : Application() {


    override fun onCreate() {
        super.onCreate()
        initKoin()
    }



    private fun initKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@TestProjectApp)
            modules(
                listOf(
                    AppModule.module,
                    ViewModelModule.module,
                    NetworkModule.module,
                    RepositoryModule.module,
                )
            )
        }
    }
}

package com.example.testproject.di


import com.example.testproject.data.repository.TestRepository
import com.example.testproject.data.repository.TestRepositoryImpl
import com.example.testproject.data.source.remote.test_project.NetworkManagerTestProject
import com.example.testproject.data.source.remote.test_project.NetworkManagerTestProjectImpl
import org.koin.dsl.module

object RepositoryModule {


    val module = module {
        single<NetworkManagerTestProject> {
            NetworkManagerTestProjectImpl(get())
        }

        single<TestRepository> {
            TestRepositoryImpl(get())
        }

    }
}

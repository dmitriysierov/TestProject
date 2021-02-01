package com.example.testproject.di

import com.example.testproject.data.source.remote.test_project.TestProjectApi
import com.example.testproject.util.contants.NetworkConstants
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object NetworkModule {
        val module = module {
            single {
                OkHttpClient.Builder()
                        .build()
            }

            single {
                GsonBuilder()
                        .setLenient()
                        .serializeNulls()
                        .create()
            }

            single {
                Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create(get()))
                        .baseUrl(NetworkConstants.BASE_URL)
                        .client(get())
                        .build()
            }

            single { get<Retrofit>().create(TestProjectApi::class.java) }
        }
}

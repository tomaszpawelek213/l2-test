package com.example.l2_test.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    single {
        OkHttpClient.Builder().build() // klient http
    }

    single {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    single{
        Retrofit.Builder()
            .client(get())
            .baseUrl("https://api.ratesapi.io/api/")
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }


}
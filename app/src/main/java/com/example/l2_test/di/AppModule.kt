package com.example.l2_test.di

import com.example.l2_test.network.RateApiService
import com.example.l2_test.network.RatesRepository
import com.example.l2_test.ui.second.SecondViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder().build() // klient http
    }

    single<Moshi> {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .client(get())
            .baseUrl("https://api.ratesapi.io/api/")
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single<RateApiService> {
        get<Retrofit>().create(RateApiService::class.java)
    }

    single { RatesRepository(get()) }

    viewModel { SecondViewModel(get()) }
}
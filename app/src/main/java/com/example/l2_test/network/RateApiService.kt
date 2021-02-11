package com.example.l2_test.network

import retrofit2.http.GET
import retrofit2.http.Query

interface RateApiService {
    @GET("latest")
    suspend fun getRates(
        @Query("base") base: String,
        @Query("rates") rates: String
    ): CalculatedRatesResponse
}


data class CalculatedRatesResponse(
    val base:String,
    val rates: Rates,
    val date:String
)

data class Rates(val USD: Double)

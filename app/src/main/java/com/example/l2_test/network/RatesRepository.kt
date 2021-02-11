package com.example.l2_test.network

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RatesRepository(
    private val rateApiService: RateApiService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun getPLNToUSDRate() {
        return withContext(dispatcher) {
            rateApiService.getRates(
                base = "PLN",
                rates = "USD"
            )
        }
    }
}
package com.sc.multimodule.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface CoinApi {

    @GET("ticker")
    suspend fun getCoin(
        @Query("currency") currency: String
    ): TickerResponse
}
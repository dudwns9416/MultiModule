package com.sc.domain

import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    suspend fun getCoin(currency: String): Coin?

    fun streamCoin(currency: String): Flow<Coin>
}
package com.sc.multimodule.data.repository

import com.sc.domain.Coin
import com.sc.domain.CoinRepository
import com.sc.multimodule.data.mapper.toDomain
import com.sc.multimodule.data.remote.CoinApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinApi: CoinApi,
) : CoinRepository {
    override suspend fun getCoin(currency: String): Coin? {
        return try {
            coinApi.getCoin(currency).toDomain()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override fun streamCoin(currency: String): Flow<Coin> {
        return flow {
            while (true) {
                try {
                    emit(coinApi.getCoin(currency).toDomain())
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                delay(5000)
            }
        }
    }
}
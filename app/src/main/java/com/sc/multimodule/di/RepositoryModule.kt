package com.sc.multimodule.di

import com.sc.domain.CoinRepository
import com.sc.multimodule.data.repository.CoinRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideCoinRepository(): CoinRepository {
        return CoinRepositoryImpl()
    }
}*/

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCoinRepository(coinRepository: CoinRepositoryImpl): CoinRepository
}
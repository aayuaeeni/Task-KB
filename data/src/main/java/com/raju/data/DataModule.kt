package com.raju.data

import com.raju.data.repository.OrderDataRepository
import com.raju.domain.repository.OrderRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideFeedDataRepository(orderDataRepository: OrderDataRepository): OrderRepository {
        return orderDataRepository
    }

}
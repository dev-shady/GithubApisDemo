package com.devshady.githubapidemo.data.di

import com.devshady.githubapidemo.data.MockProductsRepository
import com.devshady.githubapidemo.data.ProductsRepositoryImpl
import com.devshady.githubapidemo.data.remote.RetrofitRemoteDataSource
import com.devshady.githubapidemo.domain.ProductsRepository
import com.devshady.githubapidemo.domain.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsRepository(impl: ProductsRepositoryImpl) : ProductsRepository

    @Binds
    @Singleton
    abstract fun bindsRemoteDataSource(impl: RetrofitRemoteDataSource) : RemoteDataSource

}
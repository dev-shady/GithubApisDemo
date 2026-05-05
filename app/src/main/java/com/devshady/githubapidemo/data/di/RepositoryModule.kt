package com.devshady.githubapidemo.data.di

import com.devshady.githubapidemo.data.GithubRepositoryImpl
import com.devshady.githubapidemo.data.RetrofitRemoteDataSource
import com.devshady.githubapidemo.domain.GithubRepository
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
    abstract fun bindsGithubRepository(impl: GithubRepositoryImpl): GithubRepository

    @Binds
    @Singleton
    abstract fun bindsRemoteDataSource(impl: RetrofitRemoteDataSource): RemoteDataSource
}
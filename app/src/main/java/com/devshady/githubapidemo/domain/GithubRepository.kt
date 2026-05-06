package com.devshady.githubapidemo.domain

import kotlinx.coroutines.flow.Flow

interface GithubRepository {
    fun getUsers(): Flow<Resource<List<User>>>
    suspend fun loadMoreUsers(): Flow<Resource<List<User>>>
    fun getUser(userId: String) : Flow<UserDetails> //TODO have separate models
}
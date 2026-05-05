package com.devshady.githubapidemo.domain

import kotlinx.coroutines.flow.Flow

interface GithubRepository {
    fun getUsers(): Flow<List<User>>
    suspend fun loadMoreUsers(): List<User>
    fun getUser(userId: String) : Flow<UserDetails> //TODO have separate models
}
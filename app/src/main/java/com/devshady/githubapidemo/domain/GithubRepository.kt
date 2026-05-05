package com.devshady.githubapidemo.domain

import kotlinx.coroutines.flow.Flow

interface GithubRepository {
    fun getUsers(): Flow<List<User>>
    suspend fun loadMoreUsers(): List<User>
    suspend fun getUser(userId: String) : User //TODO have separate models
}
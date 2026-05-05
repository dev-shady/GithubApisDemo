package com.devshady.githubapidemo.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface GithubRepository {
    fun getPagedUsers(): Flow<PagingData<User>>
    fun getUser(userId: String) : Flow<UserDetails> //TODO have separate models
}
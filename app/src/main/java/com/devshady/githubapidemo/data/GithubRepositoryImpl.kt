package com.devshady.githubapidemo.data

import com.devshady.githubapidemo.domain.GithubRepository
import com.devshady.githubapidemo.domain.RemoteDataSource
import com.devshady.githubapidemo.domain.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GithubRepositoryImpl(val remoteDataSource: RemoteDataSource): GithubRepository {
    override fun getUsers(): Flow<List<User>> {
        return flow {
            emit(
                remoteDataSource.getUsers().map { it.toUser() }
            )
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun loadMoreUsers(): List<User> {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(userId: String): User {
        TODO("Not yet implemented")
    }
}
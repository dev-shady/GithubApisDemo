package com.devshady.githubapidemo.data

import com.devshady.githubapidemo.domain.GithubRepository
import com.devshady.githubapidemo.domain.RemoteDataSource
import com.devshady.githubapidemo.domain.User
import com.devshady.githubapidemo.domain.UserDetails
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GithubRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): GithubRepository {
    override fun getUsers(): Flow<List<User>> {
        return flow {
            emit(
                remoteDataSource.getUsers().map { it.toUser() }
            )
        }.flowOn(ioDispatcher )
    }

    override suspend fun loadMoreUsers(): List<User> {
        TODO("Not yet implemented")
    }

    override fun getUser(userId: String): Flow<UserDetails> {
        return flow {
            emit(remoteDataSource.getUser(userId).toUser())
        }.flowOn(Dispatchers.IO)
    }
}
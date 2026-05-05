package com.devshady.githubapidemo.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.devshady.githubapidemo.data.paging.UserPagingSource
import com.devshady.githubapidemo.domain.GithubRepository
import com.devshady.githubapidemo.domain.RemoteDataSource
import com.devshady.githubapidemo.domain.User
import com.devshady.githubapidemo.domain.UserDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val userPagingSource: UserPagingSource,
    private val remoteDataSource: RemoteDataSource
): GithubRepository {
    override fun getPagedUsers(): Flow<PagingData<User>> {
        return Pager(
            config = PagingConfig(pageSize = 10, prefetchDistance = 2),
            pagingSourceFactory = { userPagingSource }
        ).flow
    }

    override fun getUser(userId: String): Flow<UserDetails> {
        return flow {
            emit(remoteDataSource.getUser(userId).toUser())
        }.flowOn(Dispatchers.IO)
    }
}
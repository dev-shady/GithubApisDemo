package com.devshady.githubapidemo.data

import com.devshady.githubapidemo.domain.AppException
import com.devshady.githubapidemo.domain.GithubRepository
import com.devshady.githubapidemo.domain.RemoteDataSource
import com.devshady.githubapidemo.domain.Resource
import com.devshady.githubapidemo.domain.User
import com.devshady.githubapidemo.domain.UserDetails
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): GithubRepository {
    override fun getUsers(): Flow<Resource<List<User>>> {
        return flow {
            emit(
                try {
                    val response = remoteDataSource.getUsers()
                    if (response.isSuccessful) {
                        Resource.Success(response.body()?.map { it.toUser() } ?: emptyList())
                    } else {
                        // Handles 4xx and 5xx errors
                        Resource.Failure(AppException.ServerError)
                    }
                } catch (e: IOException) {
                    // Handles No Internet / Timeouts
                    Resource.Failure(AppException.NetworkError)
                } catch (e: Exception) {
                    Resource.Failure(AppException.UnknownError(e.message ?: "Unknown"))
                }
            )


        }.flowOn(ioDispatcher )
    }

    override suspend fun loadMoreUsers(): Flow<Resource<List<User>>> {
        TODO("Not yet implemented")
    }

    override fun getUser(userId: String): Flow<UserDetails> {
        return flow {
            emit(remoteDataSource.getUser(userId).toUser())
        }.flowOn(Dispatchers.IO)
    }
}
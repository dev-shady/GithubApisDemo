package com.devshady.githubapidemo.data

import com.devshady.githubapidemo.data.remote.GithubApi
import com.devshady.githubapidemo.domain.RemoteDataSource
import javax.inject.Inject

class RetrofitRemoteDataSource @Inject constructor(val api: GithubApi): RemoteDataSource {
    override suspend fun getUsers(): List<UserDto> {
        return api.getUsers(
            pageSize = 10
        )
    }

    override suspend fun getUser(id: String): UserDetailsDto {
        return api.getUser(id)
    }
}

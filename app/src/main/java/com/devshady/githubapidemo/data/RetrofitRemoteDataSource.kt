package com.devshady.githubapidemo.data

import com.devshady.githubapidemo.data.retrofit.GithubApi
import com.devshady.githubapidemo.domain.RemoteDataSource

class RetrofitRemoteDataSource(val api: GithubApi): RemoteDataSource {
    override suspend fun getUsers(): List<UserDto> {
        return api.getUsers(
            pageSize = 10
        )
    }
}

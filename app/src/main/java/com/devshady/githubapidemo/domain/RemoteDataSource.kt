package com.devshady.githubapidemo.domain

import com.devshady.githubapidemo.data.UserDto

interface RemoteDataSource {

    suspend fun getUsers() : List<UserDto>

}
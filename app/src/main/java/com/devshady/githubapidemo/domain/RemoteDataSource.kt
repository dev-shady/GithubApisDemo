package com.devshady.githubapidemo.domain

import com.devshady.githubapidemo.data.UserDetailsDto
import com.devshady.githubapidemo.data.UserDto

interface RemoteDataSource {

    suspend fun getUsers() : List<UserDto>
    suspend fun getUser(id: String) : UserDetailsDto

}
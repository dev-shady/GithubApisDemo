package com.devshady.githubapidemo.domain

import com.devshady.githubapidemo.data.UserDetailsDto
import com.devshady.githubapidemo.data.UserDto
import retrofit2.Response

interface RemoteDataSource {

    suspend fun getUsers() : Response<List<UserDto>>
    suspend fun getUser(id: String) : UserDetailsDto

    suspend fun getNextPage():  Response<List<UserDto>>

}
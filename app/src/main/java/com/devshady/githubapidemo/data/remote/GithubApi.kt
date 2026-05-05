package com.devshady.githubapidemo.data.remote

import com.devshady.githubapidemo.data.UserDetailsDto
import com.devshady.githubapidemo.data.UserDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url


interface GithubApi {

    @GET("/users")
    suspend fun getUsers(
        @Query("per_page") pageSize: Int
    ): Response<List<UserDto>>

    @GET("/users/{id}")
    suspend fun getUser(
        @Path("id") id: String
    ): Response<UserDetailsDto>

    @GET
    suspend fun getUsersNextPage(@Url url: String): Response<List<UserDto>>

}
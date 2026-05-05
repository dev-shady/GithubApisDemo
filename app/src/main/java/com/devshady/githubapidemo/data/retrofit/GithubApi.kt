package com.devshady.githubapidemo.data.retrofit

import com.devshady.githubapidemo.data.UserDetailsDto
import com.devshady.githubapidemo.data.UserDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface GithubApi {

    @GET("/users")
    suspend fun getUsers(
        @Query("per_page") pageSize: Int
    ): List<UserDto>

    @GET("/users/{id}")
    suspend fun getUser(
        @Path("id") id: String
    ): UserDetailsDto

}
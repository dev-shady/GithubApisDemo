package com.devshady.githubapidemo.data

import com.devshady.githubapidemo.domain.GithubRepository
import com.devshady.githubapidemo.domain.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MockGithubRepository: GithubRepository {

    val mockData = listOf(
        UserDto(
            profileUrl = "https://avatars.githubusercontent.com/u/1?v=4",
            name = "Tom Hardy",
            company = "AppsForBharat",
            blogUrl = "http://tom.preston-werner.com",
            location = "Newyork"
        ),
        UserDto(
            profileUrl = "https://avatars.githubusercontent.com/u/1?v=4",
            name = "Tom Hardy",
            company = "AppsForBharat",
            blogUrl = "http://tom.preston-werner.com",
            location = "Newyork"
        ),
        UserDto(
            profileUrl = "https://avatars.githubusercontent.com/u/1?v=4",
            name = "Tom Hardy",
            company = "AppsForBharat",
            blogUrl = "http://tom.preston-werner.com",
            location = "Newyork"
        ),
        UserDto(
            profileUrl = "https://avatars.githubusercontent.com/u/1?v=4",
            name = "Tom Hardy",
            company = "AppsForBharat",
            blogUrl = "http://tom.preston-werner.com",
            location = "Newyork"
        ),
        UserDto(
            profileUrl = "https://avatars.githubusercontent.com/u/1?v=4",
            name = "Tom Hardy",
            company = "AppsForBharat",
            blogUrl = "http://tom.preston-werner.com",
            location = "Newyork"
        ),
    )

    override fun getUsers(): Flow<List<User>> = flow {
         emit(mockData.map { it.toUser() })
    }

    override suspend fun loadMoreUsers(): List<User> {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(userId: String): User {
        TODO("Not yet implemented")
    }
}
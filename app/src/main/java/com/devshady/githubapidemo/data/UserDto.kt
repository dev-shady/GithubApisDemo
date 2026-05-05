package com.devshady.githubapidemo.data

import com.devshady.githubapidemo.domain.User

class UserDto (
    val profileUrl: String,
    val name: String,
    val company: String,
    val blogUrl: String,
    val location: String,
) {
    fun toUser(): User {
        return User(
            profileUrl,
            name,
            company,
            blogUrl,
            location
        )
    }
}
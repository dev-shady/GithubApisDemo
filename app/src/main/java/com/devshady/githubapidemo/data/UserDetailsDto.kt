package com.devshady.githubapidemo.data

import com.devshady.githubapidemo.domain.User
import com.devshady.githubapidemo.domain.UserDetails
import kotlinx.serialization.Serializable

@Serializable
class UserDetailsDto(
    val avatar_url: String,
    val company: String = "None",
    val blog: String = "None",
    val location: String = "None",
    val public_repos: Int,
    val followers: Int,
    val following: Int,

) {
    fun toUser(): UserDetails {
        return UserDetails(
            avatar_url,
            company,
            blog,
            location,
            public_repos,
            followers,
            following
        )
    }
}
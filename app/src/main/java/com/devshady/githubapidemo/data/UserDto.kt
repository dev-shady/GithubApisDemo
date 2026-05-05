package com.devshady.githubapidemo.data

import com.devshady.githubapidemo.domain.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserDto (
    @SerialName("avatar_url") val profileUrl: String,
    @SerialName("login") val name: String = "DefaultName",
    @SerialName("organizations_url") val company: String,
    @SerialName("url") val blogUrl: String,
    @SerialName("location") val location: String = "DefaultLocation",
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
package com.devshady.githubapidemo.navigation

import kotlinx.serialization.Serializable

interface Route {
    @Serializable object UsersList: Route
    @Serializable class UserDetails(val id: String): Route
}
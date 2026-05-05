package com.devshady.githubapidemo.ui.users.feed

import com.devshady.githubapidemo.domain.User
import com.devshady.githubapidemo.domain.UserDetails
import com.devshady.githubapidemo.ui.users.details.UserDetailsViewModel
import com.devshady.githubapidemo.ui.users.feed.UsersListViewModel.UserView
import com.devshady.githubapidemo.ui.users.details.UserDetailsViewModel.UserDetailsView
import kotlin.String

fun User.toView(): UserView {
        return UserView(
            profileUrl,
            name,
            company,
            blogUrl,
            location
        )
}

fun UserDetails.toDetailsView(): UserDetailsView {
    return UserDetailsView(
        avatar_url,
        company,
        blog,
        location,
        public_repos,
        followers,
        following
    )
}
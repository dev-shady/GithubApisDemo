package com.devshady.githubapidemo.ui.users.feed

import com.devshady.githubapidemo.domain.UserDetails
import com.devshady.githubapidemo.ui.users.details.UserDetailsViewModel.UserDetailsView

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
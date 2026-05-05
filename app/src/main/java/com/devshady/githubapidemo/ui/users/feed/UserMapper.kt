package com.devshady.githubapidemo.ui.users.feed

import com.devshady.githubapidemo.domain.User
import com.devshady.githubapidemo.ui.users.feed.UsersListViewModel.UserView

fun User.toView(): UserView {
        return UserView(
            profileUrl,
            name,
            company,
            blogUrl,
            location
        )
}
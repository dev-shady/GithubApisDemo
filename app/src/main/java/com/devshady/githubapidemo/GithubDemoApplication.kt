package com.devshady.githubapidemo

import android.app.Application
import com.devshady.githubapidemo.data.MockGithubRepository

class GithubDemoApplication: Application() {

    val mockRepository = MockGithubRepository()
}
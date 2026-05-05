package com.devshady.githubapidemo

import android.app.Application
import com.devshady.githubapidemo.data.GithubRepositoryImpl
import com.devshady.githubapidemo.data.MockGithubRepository
import com.devshady.githubapidemo.data.RetrofitRemoteDataSource
import com.devshady.githubapidemo.data.retrofit.GithubApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class GithubDemoApplication: Application() {

    val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }

    val contentType = "application/json".toMediaType()
    val mockRepository = MockGithubRepository()
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com") //TODO use Build.Config
        .client(OkHttpClient())
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()

    val githubApi = retrofit.create(GithubApi::class.java)
    val retrofitRemoteSource = RetrofitRemoteDataSource(githubApi)
    val repository = GithubRepositoryImpl(retrofitRemoteSource)
}
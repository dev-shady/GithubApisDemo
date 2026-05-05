package com.devshady.githubapidemo.data

import android.util.Log
import com.devshady.githubapidemo.data.remote.GithubApi
import com.devshady.githubapidemo.domain.RemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class RetrofitRemoteDataSource @Inject constructor(private val api: GithubApi): RemoteDataSource {

    private var nextUrl: String? = null

    override suspend fun getUsers(): List<UserDto> {
        val response = api.getUsers(
            pageSize = 10
        )
        return handleResponse(response)
    }

    private fun handleResponse(response: Response<List<UserDto>>): List<UserDto> {
        if (response.isSuccessful) {
            val linkHeader = response.headers()["Link"]
            nextUrl = parseLinkHeader(linkHeader)
            Log.d("aamku retrofit ", "next= ${nextUrl}")
            return response.body() ?: emptyList()
        }

        throw Exception("API error")
    }

    private fun parseLinkHeader(linkHeader: String?): String? {
        if (linkHeader.isNullOrBlank()) return null
        val regex = Regex("<([^>]+)>;\\s*rel=\"next\"")
        val match = regex.find(linkHeader)
        return match?.groupValues?.get(1)
    }

    override suspend fun getUser(id: String): UserDetailsDto {
        val response =  api.getUser(id)
        return response.body() ?: throw Exception("Network Error")
    }

    override suspend fun getNextPage(): List<UserDto> {
        if (nextUrl.isNullOrBlank()) return emptyList()
        val response = api.getUsersNextPage(nextUrl!!)
        return handleResponse(response)
    }
}

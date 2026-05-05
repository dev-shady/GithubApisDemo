package com.devshady.githubapidemo.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.devshady.githubapidemo.data.UserDto
import com.devshady.githubapidemo.data.remote.GithubApi
import com.devshady.githubapidemo.domain.User
import retrofit2.Response

class UserPagingSource(
    val api: GithubApi
): PagingSource<String, User>() {
    override suspend fun load(params: LoadParams<String>): LoadResult<String, User> {
       return try {
           val key = params.key
           val pageSize = params.loadSize
           val response = if (key == null) {
               api.getUsers(pageSize)
           } else {
               api.getUsersNextPage(key)
           }

           val nextUrl = handleResponse(response)
           val data = response.body() ?: emptyList()

           return LoadResult.Page(
               data = data.map { it.toUser() },
               prevKey = null,
               nextKey = nextUrl
           )
       } catch(e: Exception) {
           LoadResult.Error(e)
       }
    }

    private fun handleResponse(response: Response<List<UserDto>>): String? {
        if (response.isSuccessful) {
            val linkHeader = response.headers()["Link"]
            val nextUrl = parseLinkHeader(linkHeader)
           return nextUrl
        }
        return null
    }

    private fun parseLinkHeader(linkHeader: String?): String? {
        if (linkHeader.isNullOrBlank()) return null
        val regex = Regex("<([^>]+)>;\\s*rel=\"next\"")
        val match = regex.find(linkHeader)
        return match?.groupValues?.get(1)
    }

    override fun getRefreshKey(state: PagingState<String, User>): String? {
        return null
    }
}
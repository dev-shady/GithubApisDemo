package com.devshady.githubapidemo.data.remote

import coil.network.HttpException
import com.devshady.githubapidemo.domain.AppException
import com.devshady.githubapidemo.domain.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import okio.IOException
import retrofit2.Response

suspend fun <T> safeCallHelper(
    coroutineDispatcher: CoroutineDispatcher,
    block: suspend () -> Response<T>
): Resource<T> {

    return withContext(coroutineDispatcher) {
        try {
            val response = block()
            if (response.isSuccessful) {
                Resource.Success(response.body() ?: throw Exception("empty body"))
            } else {
                Resource.Failure(AppException.ServerError)
            }

        } catch (e: IOException) {
            Resource.Failure(AppException.NetworkError)
        } catch (e: Exception) {
            Resource.Failure(AppException.UnknownError(e.message ?: "unknown"))
        }
    }




}
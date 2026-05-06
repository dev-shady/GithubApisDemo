package com.devshady.githubapidemo.domain

sealed class Resource<out T> {
    data class Success<out T>(val data : T): Resource<T>()
    data class Failure(val e: AppException): Resource<Nothing>()
}

sealed class AppException {
    object NetworkError: AppException()
    object ServerError: AppException()
    data class UnknownError(val msg: String): AppException()
}
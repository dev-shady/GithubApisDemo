package com.devshady.githubapidemo.data.remote

import com.devshady.githubapidemo.data.ProductDto
import com.devshady.githubapidemo.data.ProductResponse
import com.devshady.githubapidemo.domain.RemoteDataSource
import javax.inject.Inject

class RetrofitRemoteDataSource @Inject constructor (
    val api: ProductApi
): RemoteDataSource {

    override suspend fun getProducts(): ProductResponse {
        return api.getProducts()
    }
}
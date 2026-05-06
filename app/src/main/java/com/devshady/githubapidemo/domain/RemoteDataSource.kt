package com.devshady.githubapidemo.domain

import com.devshady.githubapidemo.data.ProductDto
import com.devshady.githubapidemo.data.ProductResponse

interface RemoteDataSource {
    suspend fun getProducts(): ProductResponse

}
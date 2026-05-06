package com.devshady.githubapidemo.domain

import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    fun getProducts(): Flow<List<Product>>
}
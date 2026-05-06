package com.devshady.githubapidemo.data

import com.devshady.githubapidemo.domain.Product
import com.devshady.githubapidemo.domain.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MockProductsRepository @Inject constructor() : ProductsRepository {
    override fun getProducts(): Flow<List<Product>> {
        return flow {
            emit(
                listOf(

                )
            )
        }
    }
}
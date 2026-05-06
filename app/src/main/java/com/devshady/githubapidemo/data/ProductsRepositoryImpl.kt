package com.devshady.githubapidemo.data

import com.devshady.githubapidemo.domain.Product
import com.devshady.githubapidemo.domain.ProductsRepository
import com.devshady.githubapidemo.domain.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor (
    private val remoteDataSource: RemoteDataSource
): ProductsRepository {
    override fun getProducts(): Flow<List<Product>> {
        return flow {
            emit(
                remoteDataSource.getProducts().products.map { it.toProduct() }
            )
        }
    }
}
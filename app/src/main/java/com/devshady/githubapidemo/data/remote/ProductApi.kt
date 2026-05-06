package com.devshady.githubapidemo.data.remote

import com.devshady.githubapidemo.data.ProductDto
import com.devshady.githubapidemo.data.ProductResponse
import retrofit2.http.GET

interface ProductApi {

    @GET("/products")
    suspend fun getProducts(): ProductResponse
}

//https://dummyjson.com/products?limit=20&skip=0
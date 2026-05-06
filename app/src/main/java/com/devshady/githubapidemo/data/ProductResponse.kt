package com.devshady.githubapidemo.data

import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse (
    val products: List<ProductDto>
)
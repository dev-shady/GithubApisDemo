package com.devshady.githubapidemo.data

import com.devshady.githubapidemo.domain.Product
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductDto(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
) {
    fun toProduct(): Product {
        return Product(
            id,
            title,
            description,
            price
        )
    }
}

//"id": 21,
//"title": "Cucumber",
//"description": "Crisp and hydrating cucumbers, ideal for salads, snacks, or as a refreshing side.",
//"category": "groceries",
//"price": 1.49,
//"discountPercentage": 0.16,
//"rating": 4.07,
//"stock": 84,
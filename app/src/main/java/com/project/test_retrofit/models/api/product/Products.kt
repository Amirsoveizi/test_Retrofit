package com.project.test_retrofit.models.api.product

import com.project.test_retrofit.models.api.product.Product

data class Products(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)
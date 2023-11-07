package com.letslearntogether.madkart.domain.interfaces.repositories

import com.letslearntogether.madkart.domain.entities.errorhandling.products.ProductCardData
import com.letslearntogether.madkart.domain.entities.errorhandling.products.ProductDetails

interface ProductRepository {

    suspend fun getProductList(): List<ProductCardData>

    suspend fun getProductDetails(productId: String): ProductDetails
}
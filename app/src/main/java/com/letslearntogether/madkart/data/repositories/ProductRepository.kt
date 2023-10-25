package com.letslearntogether.madkart.data.repositories

import com.letslearntogether.madkart.domain.usecases.products.ProductCardData
import com.letslearntogether.madkart.domain.usecases.products.ProductDetails

interface ProductRepository {

   suspend fun getProductList():List<ProductCardData>

   suspend fun getProductDetails(productId: String):ProductDetails
}
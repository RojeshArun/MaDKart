package com.letslearntogether.madkart.data.repositories

import com.letslearntogether.madkart.domain.usecases.products.ProductCardData

interface ProductRepository {

   suspend fun getProductList():List<ProductCardData>
}
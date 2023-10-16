package com.letslearntogether.madkart

interface ProductRepository {

   suspend fun getProductList():List<ProductCardData>
}
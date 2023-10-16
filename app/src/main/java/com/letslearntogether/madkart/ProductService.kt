package com.letslearntogether.madkart

import retrofit2.http.GET

interface ProductService {

    @GET("products")
    suspend fun getProductList(): List<ProductEntity>
}
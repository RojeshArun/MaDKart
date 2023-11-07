package com.letslearntogether.madkart.data.network

import com.letslearntogether.madkart.data.network.models.ProductDetailsEntity
import com.letslearntogether.madkart.data.network.models.ProductEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    //Step 3
    @GET("products")
    suspend fun getProductList(): List<ProductEntity>

    @GET("productDetails")
    suspend fun getProductDetails(@Query("productId") productId: String): ProductDetailsEntity
}
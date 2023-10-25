package com.letslearntogether.madkart.data.repositories.api

import com.letslearntogether.madkart.data.repositories.api.models.ProductDetailsEntity
import com.letslearntogether.madkart.data.repositories.api.models.ProductEntity
import com.letslearntogether.madkart.domain.usecases.products.ProductDetails
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    //Step 3
    @GET("products")
    suspend fun getProductList(): List<ProductEntity>

    @GET("productDetails")
    suspend fun getProductDetails(@Query("productId") productId: String): ProductDetailsEntity
}
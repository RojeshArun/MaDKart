package com.letslearntogether.madkart.data.repositories.api

import com.letslearntogether.madkart.data.repositories.api.models.ProductEntity
import retrofit2.http.GET

interface ProductService {
    //Step 3
    @GET("products")
    suspend fun getProductList(): List<ProductEntity>
}
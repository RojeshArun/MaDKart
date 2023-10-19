package com.letslearntogether.madkart

import dagger.Binds
import retrofit2.http.GET

interface ProductService {
    //Step 3
    @GET("products")
    suspend fun getProductList(): List<ProductEntity>
}
package com.letslearntogether.madkart

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ProductRepository {

    private val client = APIClient().getClient()

    suspend fun getProductList(): List<ProductCardData> {

        return withContext(Dispatchers.IO) {
            client.getProductList().map{
                ProductCardData(
                it.title,
                it.description,
                    "US $ ${it.price}",
                it.imageUrl
                )
            }
        }
    }
}
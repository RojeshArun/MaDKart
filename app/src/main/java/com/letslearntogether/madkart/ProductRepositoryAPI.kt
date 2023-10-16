package com.letslearntogether.madkart

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRepositoryAPI :ProductRepository{

    private val client = APIClient().getClient()

    override suspend fun getProductList(): List<ProductCardData> {
        //Step 5
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
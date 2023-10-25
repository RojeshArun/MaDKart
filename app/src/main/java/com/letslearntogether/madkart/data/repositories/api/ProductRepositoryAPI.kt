package com.letslearntogether.madkart.data.repositories.api

import com.letslearntogether.madkart.domain.usecases.products.ProductCardData
import com.letslearntogether.madkart.data.repositories.ProductRepository
import com.letslearntogether.madkart.domain.usecases.products.ProductDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

//Step 2 Hilt
class ProductRepositoryAPI @Inject constructor(private val service: ProductService) :
    ProductRepository {

    override suspend fun getProductList(): List<ProductCardData> {
        //Step 3 Hilt
        return withContext(Dispatchers.IO) {
            service.getProductList().map{
                ProductCardData( // Any Optimization can we do here?
                    it.title,
                    it.description,
                    "US $ ${it.price}",
                    it.imageUrl,
                    it.id
                )
            }
        }
    }

    override suspend fun getProductDetails(productId: String): ProductDetails {
        return  withContext(Dispatchers.IO){
            service.getProductDetails(productId).run {
                ProductDetails(
                    this.title,
                    this.description,
                    this.full_description,
                    "US $ ${this.price}",
                    this.imageUrl,
                    this.pros,
                    this.cons
                )
            }
        }
    }
}
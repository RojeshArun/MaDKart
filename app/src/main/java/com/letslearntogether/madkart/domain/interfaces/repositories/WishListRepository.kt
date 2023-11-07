package com.letslearntogether.madkart.domain.interfaces.repositories
//Step 3 - Expose to the above layers room db
interface WishListRepository {

    suspend fun isFavorite(productId: String): Boolean
    suspend fun addToWishList(productId: String)
    suspend fun removeFromWishList(productId: String)
}
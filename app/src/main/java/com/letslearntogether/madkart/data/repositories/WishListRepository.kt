package com.letslearntogether.madkart.data.repositories

interface WishListRepository {

    suspend fun isFavorite(productId: String): Boolean
    suspend fun addToWishList(productId: String)
    suspend fun removeFromWishList(productId: String)
}
package com.letslearntogether.madkart.data.repositories

interface WishListRepository {

    fun isFavorite(productId: String): Boolean

    fun addToWishList(productId: String)

    fun removeFromWishList(productId: String)
}
package com.letslearntogether.madkart.data.repositories.api

import com.letslearntogether.madkart.data.repositories.WishListRepository
import javax.inject.Inject

class WishListDatabaseRepository @Inject constructor(): WishListRepository {

    override fun isFavorite(productId: String): Boolean {
        return true
    }

    override fun addToWishList(productId: String) {
    }

    override fun removeFromWishList(productId: String) {

    }
}
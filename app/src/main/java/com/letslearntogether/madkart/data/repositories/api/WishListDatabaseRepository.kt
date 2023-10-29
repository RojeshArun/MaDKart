package com.letslearntogether.madkart.data.repositories.api

import com.letslearntogether.madkart.data.repositories.WishListRepository
import com.letslearntogether.madkart.data.repositories.database.FavouriteProductEntity
import com.letslearntogether.madkart.data.repositories.database.WishListDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WishListDatabaseRepository @Inject constructor(
    private val databaseDAO: WishListDao
) : WishListRepository {

    override suspend fun isFavorite(productId: String): Boolean {
        return withContext(Dispatchers.IO) {
            databaseDAO.isProductFavourite(productId) != null
        }
    }

    override suspend fun addToWishList(productId: String) {
        return withContext(Dispatchers.IO){
            databaseDAO.addProductToFavourites(
                FavouriteProductEntity(productId,"")
            )
        }
    }

    override suspend fun removeFromWishList(productId: String) {
        return withContext(Dispatchers.IO){
            databaseDAO.removeProductToFavourites(
                FavouriteProductEntity(productId,"")
            )
        }
    }
}
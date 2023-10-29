package com.letslearntogether.madkart.data.repositories.database

import com.letslearntogether.madkart.data.repositories.WishListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WishListDatabaseRepository @Inject constructor(
    private val dataBaseDao: WishListDao
) : WishListRepository {

    override suspend fun isFavorite(productId: String): Boolean {
        return withContext(Dispatchers.IO) {
            dataBaseDao.isProductFavourite(productId) != null
        }
    }

    override suspend fun addToWishList(productId: String) {
        return withContext(Dispatchers.IO) {
            dataBaseDao.addProductToFavourites(
                FavouriteProductEntity(productId, "")
            )
        }
    }

    override suspend fun removeFromWishList(productId: String) {
        return withContext(Dispatchers.IO) {
            dataBaseDao.removeProductToFavourites(
                FavouriteProductEntity(productId, "")
            )
        }
    }
}
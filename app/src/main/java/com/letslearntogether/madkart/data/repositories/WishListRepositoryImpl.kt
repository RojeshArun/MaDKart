package com.letslearntogether.madkart.data.repositories

import com.letslearntogether.madkart.data.persistentstorages.database.tableEntities.FavouriteProductTable
import com.letslearntogether.madkart.data.persistentstorages.database.dao.WishListDao
import com.letslearntogether.madkart.domain.interfaces.repositories.WishListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
//Step 4 Repository implementation
class WishListRepositoryImpl @Inject constructor(
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
                FavouriteProductTable(productId, "")
            )
        }

    }

    override suspend fun removeFromWishList(productId: String) {
        return withContext(Dispatchers.IO) {
            dataBaseDao.removeProductToFavourites(
                FavouriteProductTable(productId, "")
            )
        }
    }
}
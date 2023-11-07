package com.letslearntogether.madkart.data.network

import com.letslearntogether.madkart.domain.interfaces.repositories.WishListRepository
import com.letslearntogether.madkart.data.persistentstorages.database.tableEntities.FavouriteProductTable
import com.letslearntogether.madkart.data.persistentstorages.database.dao.WishListDao
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
                FavouriteProductTable(productId,"")
            )
        }
    }

    override suspend fun removeFromWishList(productId: String) {
        return withContext(Dispatchers.IO){
            databaseDAO.removeProductToFavourites(
                FavouriteProductTable(productId,"")
            )
        }
    }
}
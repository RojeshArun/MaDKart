package com.letslearntogether.madkart.data.repositories.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WishListDao {

    @Query("SELECT * FROM favouriteproductentity WHERE id=:id")
    fun isProductFavourite(id: String): FavouriteProductEntity?

    @Insert
    fun addProductToFavourites(product: FavouriteProductEntity)

    @Delete
    fun removeProductToFavourites(product: FavouriteProductEntity)
}
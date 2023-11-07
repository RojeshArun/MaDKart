package com.letslearntogether.madkart.data.persistentstorages.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.letslearntogether.madkart.data.persistentstorages.database.tableEntities.FavouriteProductTable

//Step -2 Querries on the tables Room db
@Dao
interface WishListDao {

    @Query("SELECT * FROM favouriteproductentity WHERE id=:id")
    fun isProductFavourite(id: String): FavouriteProductTable?

    @Insert
    fun addProductToFavourites(product: FavouriteProductTable)

    @Delete
    fun removeProductToFavourites(product: FavouriteProductTable)
}
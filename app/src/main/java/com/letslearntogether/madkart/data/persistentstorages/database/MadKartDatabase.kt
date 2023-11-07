package com.letslearntogether.madkart.data.persistentstorages.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.letslearntogether.madkart.data.persistentstorages.database.dao.WishListDao
import com.letslearntogether.madkart.data.persistentstorages.database.tableEntities.FavouriteProductTable

@Database(entities = [FavouriteProductTable::class], version = 1)
abstract class MadKartDatabase : RoomDatabase() {
    abstract fun wishListDao(): WishListDao
}
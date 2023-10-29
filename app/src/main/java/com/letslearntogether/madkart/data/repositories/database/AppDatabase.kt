package com.letslearntogether.madkart.data.repositories.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavouriteProductEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wishListDao(): WishListDao
}
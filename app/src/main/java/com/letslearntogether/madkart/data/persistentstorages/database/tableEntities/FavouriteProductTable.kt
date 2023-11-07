package com.letslearntogether.madkart.data.persistentstorages.database.tableEntities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Step 1 - Create Tables roomdb
@Entity
data class FavouriteProductTable(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "product_name") val productName: String
)